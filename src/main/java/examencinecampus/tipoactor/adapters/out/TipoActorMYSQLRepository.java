package examencinecampus.tipoactor.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examencinecampus.tipoactor.domain.models.TipoActor;
import examencinecampus.tipoactor.infrastructure.TipoActorRepository;

public class TipoActorMYSQLRepository implements  TipoActorRepository {

    private final String url;
    private final String user;
    private final String password;

    public TipoActorMYSQLRepository(String password, String url, String user) {
        this.password = password;
        this.url = url;
        this.user = user;
    }

    @Override
    public void save(TipoActor tipoActor) {
       try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT into tipoActor (descripcion) VALUES (?);";     
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, tipoActor.getDescripcion());
                statement.executeUpdate();
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TipoActor tipoActor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE tipoActor SET descripcion = ?;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, tipoActor.getDescripcion());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM tipoActor WHERE id = ?;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TipoActor> findAll() {
      List<TipoActor> tiposActores = new ArrayList<>();
       try (Connection connection = DriverManager.getConnection(url, user, password)) {
        String query = "SELECT * FROM tipoActor;";
        try(PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
        ){
            while(resultSet.next()){
                TipoActor tipoActor = new TipoActor(
                    resultSet.getInt("id"),
                    resultSet.getString("descripcion"));
                    tiposActores.add(tipoActor);
            }
        }
       } catch (SQLException e) {
        e.printStackTrace();
    }
    return tiposActores;
    }
}


