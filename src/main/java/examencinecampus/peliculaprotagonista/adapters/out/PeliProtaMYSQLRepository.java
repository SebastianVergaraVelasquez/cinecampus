package examencinecampus.peliculaprotagonista.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examencinecampus.peliculaprotagonista.domain.models.PeliculaProtagonista;
import examencinecampus.peliculaprotagonista.infrastructure.PeliculaProtaRepository;

public class PeliProtaMYSQLRepository implements PeliculaProtaRepository{
    private final String url;
    private final String user;
    private final String password;

    public PeliProtaMYSQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(PeliculaProtagonista peliculaProtagonista) {
       try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT into peliculaprotagonista (idpelicula, idprotagonista,idtipoactor) VALUES (?,?,?);";     
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, peliculaProtagonista.getIdPelicula());
                statement.setInt(2, peliculaProtagonista.getIdActor());
                statement.setInt(3, peliculaProtagonista.getIdTipoActor());
                statement.executeUpdate();
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PeliculaProtagonista> findAllByPeliId(int id) {
        List<PeliculaProtagonista> peliprotas = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * peliculaprotagonista WHERE id = ?;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);
                try(ResultSet resultSet = statement.executeQuery()){
                while(resultSet.next()){
                    PeliculaProtagonista peliprota = new PeliculaProtagonista(
                            resultSet.getInt("id"), 
                            resultSet.getInt("idnacionalidad"), 
                            resultSet.getInt("edad"), 
                            resultSet.getInt("idgenero"));
                            peliprotas.add(peliprota);
                    }
                }
            }
        
          }  catch (SQLException e) {
                e.printStackTrace();
            }
    return peliprotas;

    }
    
}
