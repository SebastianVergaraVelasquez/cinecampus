package examencinecampus.actor.infrastructure;

import java.util.List;

import examencinecampus.actor.domain.models.Actor;

public interface ActorRepository {
    void save(Actor actor);
    void update(Actor actor);
    void delete (int id);
    List<Actor> findAll();
}
