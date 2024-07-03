package examencinecampus.pais.application;

import java.util.List;

import examencinecampus.pais.domain.models.Pais;
import examencinecampus.pais.infrastructure.PaisRepository;

public class PaisService {
    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public void createPais(Pais pais){
        paisRepository.save(pais);
    }
    
    public void updatePais(Pais pais){
        paisRepository.update(pais);
    }

    public void deletePais(int id){
        paisRepository.delete(id);
    }

    public List<Pais> findAllFPaises(){
        return paisRepository.findAll();
    }
}
