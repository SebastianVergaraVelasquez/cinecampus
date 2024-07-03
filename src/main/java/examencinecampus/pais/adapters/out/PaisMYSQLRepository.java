package examencinecampus.pais.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examencinecampus.pais.domain.models.Pais;
import examencinecampus.pais.infrastructure.PaisRepository;

public class PaisMYSQLRepository implements  PaisRepository {

    private final String url;
    private final String user;
    private final String password;

    public PaisMYSQLRepository(String password, String url, String user) {
        this.password = password;
        this.url = url;
        this.user = user;
    }

    @Override
    public void save(Pais pais) {
       try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT into pais (descripcion) VALUES (?);";     
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, pais.getDescripcion());
                statement.executeUpdate();
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pais pais) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE pais SET descripcion = ?;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, pais.getDescripcion());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM pais WHERE id = ?;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pais> findAll() {
      List<Pais> paises = new ArrayList<>();
       try (Connection connection = DriverManager.getConnection(url, user, password)) {
        String query = "SELECT * FROM pais;";
        try(PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
        ){
            while(resultSet.next()){
                Pais pais = new Pais(
                    resultSet.getInt("id"),
                    resultSet.getString("descripcion"));
                    paises.add(pais);
            }
        }
       } catch (SQLException e) {
        e.printStackTrace();
    }
    return paises;
    }
}


