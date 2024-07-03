package examencinecampus.peliculaprotagonista.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByPeliId'");
    }

    
}
