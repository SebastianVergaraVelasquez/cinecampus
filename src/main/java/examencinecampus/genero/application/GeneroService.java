package examencinecampus.genero.application;

import java.util.List;

import examencinecampus.genero.domain.models.Genero;
import examencinecampus.genero.infrastructure.GeneroRepository;

public class GeneroService {
    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public void createFormato(Genero formato){
        generoRepository.save(formato);
    }
    
    public void updateFormato(Genero formato){
        generoRepository.update(formato);
    }

    public void deleteFormato(int id){
        generoRepository.delete(id);
    }

    public List<Genero> findAllFormatos(){
        return generoRepository.findAll();
    }
}
