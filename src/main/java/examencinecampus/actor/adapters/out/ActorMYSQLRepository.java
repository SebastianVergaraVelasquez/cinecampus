package examencinecampus.actor.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examencinecampus.actor.domain.models.Actor;
import examencinecampus.actor.infrastructure.ActorRepository;

public class ActorMYSQLRepository implements ActorRepository{

    private final String url;
    private final String user;
    private final String password;

    public ActorMYSQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Actor actor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT into actor (nombre, idnacionalidad,edad,idgenero) VALUES (?,?,?,?);";     
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, actor.getNombre());
                statement.setInt(2, actor.getIdNacionalidad());
                statement.setInt(3, actor.getEdad());
                statement.setInt(4, actor.getIdGenero());
                statement.executeUpdate();
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Actor actor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE actor SET nombre = ?, idnacionalidad = ?, edad =?, idgenero = ?;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, actor.getNombre());
                statement.setInt(2, actor.getIdNacionalidad());
                statement.setInt(3, actor.getEdad());
                statement.setInt(4, actor.getIdGenero());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM actor WHERE id = ?;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Actor> findAll() {
       List<Actor> actors = new ArrayList<>();
       try (Connection connection = DriverManager.getConnection(url, user, password)) {
        String query = "SELECT * FROM actor;";
        try(PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
        ){
            while(resultSet.next()){
                Actor actor = new Actor(
                    resultSet.getString("nombre"), 
                    resultSet.getInt("idnacionalidad"), 
                    resultSet.getInt("edad"), 
                    resultSet.getInt("idgenero"));
                actors.add(actor);
            }
        }
       } catch (SQLException e) {
        e.printStackTrace();
    }
    return actors;
    }

}
