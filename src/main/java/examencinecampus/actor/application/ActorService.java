package examencinecampus.actor.application;

import java.util.List;
import java.util.Optional;

import examencinecampus.actor.domain.models.Actor;
import examencinecampus.actor.infrastructure.ActorRepository;

public class ActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public void createActor(Actor actor){
        actorRepository.save(actor);
    }

    public void updateActor(Actor actor){
        actorRepository.update(actor);
    }

    public void deleteActor(int id){
        actorRepository.delete(id);
    }

    public List<Actor> findAllActor(){
       return actorRepository.findAll();
    }

    public Optional<Actor> findById(int id){
        return actorRepository.findById(id);
    }
}
