package examencinecampus.peliculaformato.application;

import examencinecampus.peliculaformato.infrastructure.PeliculaFormatoRepository;
import examencinecampus.peliculaformato.domain.models.PeliculaFormato;

public class PeliculaFormatoService {
    private final PeliculaFormatoRepository peliculaFormatoRepository;

    public PeliculaFormatoService(PeliculaFormatoRepository peliculaFormatoRepository) {
        this.peliculaFormatoRepository = peliculaFormatoRepository;
    }

    public void createPeliculaFormato(PeliculaFormato peliculaFormato){
        peliculaFormatoRepository.save(peliculaFormato);
    }

    public void updatePeliculaFormato(PeliculaFormato peliculaFormato){
        peliculaFormatoRepository.update(peliculaFormato);
    }

    public void deletePeliculaFormato(int id){
        peliculaFormatoRepository.delete(id);
    }

    public void findAllPeliculaFormato(){
        peliculaFormatoRepository.findAll();
    }
}
