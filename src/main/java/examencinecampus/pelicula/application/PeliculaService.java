package examencinecampus.pelicula.application;


import examencinecampus.pelicula.adapters.out.PeliculaMYSQLRepository;
import examencinecampus.pelicula.domain.models.Pelicula;

public class PeliculaService {

    private final PeliculaMYSQLRepository peliculaMYSQLRepository;

    public PeliculaService(PeliculaMYSQLRepository peliculaMYSQLRepository) {
        this.peliculaMYSQLRepository = peliculaMYSQLRepository;
    }

    public void createPelicula(Pelicula pelicula){
        peliculaMYSQLRepository.save(pelicula);
    }

    public void updatePelicula(Pelicula pelicula){
        peliculaMYSQLRepository.update(pelicula);
    }

    public void deletePelicula(int id){
        peliculaMYSQLRepository.delete(id);
    }

    public void findAllPelicula(){
        peliculaMYSQLRepository.findAll();
    }    


}
