package examencinecampus.actor.application;

import examencinecampus.actor.adapters.out.ActorMYSQLRepository;
import examencinecampus.actor.domain.models.Actor;

public class ActorService {
    private final ActorMYSQLRepository actorMYSQLRepository;

    public ActorService(ActorMYSQLRepository actorMYSQLRepository) {
        this.actorMYSQLRepository = actorMYSQLRepository;
    }

    public void createActor(Actor actor){
        actorMYSQLRepository.save(actor);
    }

    public void updateActor(Actor actor){
        actorMYSQLRepository.update(actor);
    }

    public void deleteActor(int id){
        actorMYSQLRepository.delete(id);
    }

    public void findAllActor(){
        actorMYSQLRepository.findAll();
    }
}
