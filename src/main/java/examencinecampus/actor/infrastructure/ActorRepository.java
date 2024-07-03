package examencinecampus.actor.infrastructure;

import java.util.List;
import java.util.Optional;

import examencinecampus.actor.domain.models.Actor;

public interface ActorRepository {
    void save(Actor actor);
    void update(Actor actor);
    void delete (int id);
    List<Actor> findAll();
    Optional<Actor> findById(int id);
}
