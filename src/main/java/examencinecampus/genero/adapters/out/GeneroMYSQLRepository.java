package examencinecampus.genero.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examencinecampus.genero.domain.models.Genero;
import examencinecampus.genero.infrastructure.GeneroRepository;

public class GeneroMYSQLRepository implements  GeneroRepository {

    private final String url;
    private final String user;
    private final String password;

    public GeneroMYSQLRepository(String password, String url, String user) {
        this.password = password;
        this.url = url;
        this.user = user;
    }

    @Override
    public void save(Genero genero) {
       try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT into genero (descripcion) VALUES (?);";     
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, genero.getDescripcion());
                statement.executeUpdate();
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Genero genero) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE genero SET descripcion = ?;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, genero.getDescripcion());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM genero WHERE id = ?;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Genero> findAll() {
      List<Genero> generos = new ArrayList<>();
       try (Connection connection = DriverManager.getConnection(url, user, password)) {
        String query = "SELECT * FROM genero;";
        try(PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
        ){
            while(resultSet.next()){
                Genero genero = new Genero(
                    resultSet.getInt("id"),
                    resultSet.getString("descripcion"));
                    generos.add(genero);
            }
        }
       } catch (SQLException e) {
        e.printStackTrace();
    }
    return generos;
    }
}


