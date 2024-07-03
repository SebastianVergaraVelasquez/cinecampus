package examencinecampus.formato.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examencinecampus.formato.domain.models.Formato;
import examencinecampus.formato.infrastructure.FormatoRepository;

public class FormatoMYSQLRepository implements FormatoRepository{
    private final String url;
    private final String user;
    private final String password;

    public FormatoMYSQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Formato formato) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT into formato (descripcion) VALUES (?);";     
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, formato.getDescripcion());
                statement.executeUpdate();
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Formato formato) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE formato SET descripcion = ?;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, formato.getDescripcion());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM formato WHERE id = ?;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Formato> findAll() {
       List<Formato> formatos = new ArrayList<>();
       try (Connection connection = DriverManager.getConnection(url, user, password)) {
        String query = "SELECT * FROM formato;";
        try(PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
        ){
            while(resultSet.next()){
                Formato formato = new Formato(
                    resultSet.getInt("id"),
                    resultSet.getString("descripcion"));
                formatos.add(formato);
            }
        }
       } catch (SQLException e) {
        e.printStackTrace();
    }
    return formatos;
    }
}
