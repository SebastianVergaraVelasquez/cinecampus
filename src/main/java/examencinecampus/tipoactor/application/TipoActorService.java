package examencinecampus.tipoactor.application;

import java.util.List;

import examencinecampus.tipoactor.domain.models.TipoActor;
import examencinecampus.tipoactor.infrastructure.TipoActorRepository;

public class TipoActorService {
    private final TipoActorRepository tipoActorRepository;

    public TipoActorService(TipoActorRepository tipoActorRepository) {
        this.tipoActorRepository = tipoActorRepository;
    }

    public void createTipoActor(TipoActor tipoActor){
        tipoActorRepository.save(tipoActor);
    }
    
    public void updateTipoActor(TipoActor tipoActor){
        tipoActorRepository.update(tipoActor);
    }

    public void deleteTipoActor(int id){
        tipoActorRepository.delete(id);
    }

    public List<TipoActor> findAllFTipoActores(){
        return tipoActorRepository.findAll();
    }
}
