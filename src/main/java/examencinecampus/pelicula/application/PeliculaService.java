package examencinecampus.pelicula.application;


import examencinecampus.pelicula.infrastructure.PeliculaRepository;
import examencinecampus.pelicula.domain.models.Pelicula;

public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public void createPelicula(Pelicula pelicula){
        peliculaRepository.save(pelicula);
    }

    public void updatePelicula(Pelicula pelicula){
        peliculaRepository.update(pelicula);
    }

    public void deletePelicula(int id){
        peliculaRepository.delete(id);
    }

    public void findAllPelicula(){
        peliculaRepository.findAll();
    }    


}
