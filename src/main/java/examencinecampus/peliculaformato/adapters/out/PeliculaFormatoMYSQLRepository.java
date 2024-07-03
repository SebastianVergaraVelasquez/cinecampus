package examencinecampus.peliculaformato.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import examencinecampus.peliculaformato.domain.models.PeliculaFormato;
import examencinecampus.peliculaformato.infrastructure.PeliculaFormatoRepository;

public class PeliculaFormatoMYSQLRepository implements PeliculaFormatoRepository{

    private final String url;
    private final String user;
    private final String password;

    public PeliculaFormatoMYSQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(PeliculaFormato peliculaFormato) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT into peliculaformato (idpelicula, idformato, cantidad) VALUES (?,?,?);";     
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, peliculaFormato.getIdpelicula());
                statement.setInt(2, peliculaFormato.getIdformato());
                statement.setInt(3, peliculaFormato.getCantidad());
                statement.executeUpdate();
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(PeliculaFormato peliculaFormato) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE peliculaformato SET idpelicula = ?, idformato = ?, cantidad = ?;";     
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, peliculaFormato.getIdpelicula());
                statement.setInt(2, peliculaFormato.getIdformato());
                statement.setInt(3, peliculaFormato.getCantidad());
                statement.executeUpdate();
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM peliculaformato WHERE id = ?;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PeliculaFormato> findAll() {
       List<PeliculaFormato> peliculasFormatos = new ArrayList<>();
       try (Connection connection = DriverManager.getConnection(url, user, password)) {
        String query = "SELECT * FROM peliculaformato;";
        try(PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
        ){
            while(resultSet.next()){
                PeliculaFormato peliculaFormato = new PeliculaFormato( 
                    resultSet.getInt("idpelicula"), 
                    resultSet.getInt("idformato"), 
                    resultSet.getInt("cantidad"));
                    peliculasFormatos.add(peliculaFormato);
            }
        }
       } catch (SQLException e) {
        e.printStackTrace();
    }
    return peliculasFormatos;
    }

}
