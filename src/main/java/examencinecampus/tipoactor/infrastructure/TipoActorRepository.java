package examencinecampus.tipoactor.infrastructure;

import java.util.List;

import examencinecampus.tipoactor.domain.models.TipoActor;

public interface TipoActorRepository {
    void save(TipoActor tipoActor);
    void update(TipoActor tipoActor);
    void delete (int id);
    List<TipoActor> findAll();
}
