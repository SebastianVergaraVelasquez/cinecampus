package examencinecampus.pelicula.application;


import java.util.List;
import java.util.Optional;

import examencinecampus.actor.domain.models.Actor;
import examencinecampus.actor.infrastructure.ActorRepository;
import examencinecampus.pelicula.domain.models.Pelicula;
import examencinecampus.pelicula.infrastructure.PeliculaRepository;

public class PeliculaService {

    private final PeliculaRepository peliculaRepository;
    private final ActorRepository actorRepository;

    public PeliculaService(PeliculaRepository peliculaRepository, ActorRepository actorRepository) {
        this.peliculaRepository = peliculaRepository;
        this.actorRepository = actorRepository;
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

    public List<Pelicula> findAllPelicula(){
       return peliculaRepository.findAll();
    }    

    public Optional<Pelicula> findById(int id){
        return peliculaRepository.findById(id);
    }

    public Optional<Actor> findActor(int id){
        return actorRepository.findById(id);
    }

    public List<Actor> findAllActor(){
        return actorRepository.findAll();
    }
}
