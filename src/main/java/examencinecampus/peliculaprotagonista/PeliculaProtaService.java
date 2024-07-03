package examencinecampus.peliculaprotagonista;

import java.util.List;

import examencinecampus.peliculaprotagonista.domain.models.PeliculaProtagonista;
import examencinecampus.peliculaprotagonista.infrastructure.PeliculaProtaRepository;

public class PeliculaProtaService {
    private final PeliculaProtaRepository peliculaProtaRepository;

    public PeliculaProtaService(PeliculaProtaRepository peliculaProtaRepository) {
        this.peliculaProtaRepository = peliculaProtaRepository;
    }

    public void createProtas(PeliculaProtagonista peliculaProtagonista){
        peliculaProtaRepository.save(peliculaProtagonista);
    }
    
    public List<PeliculaProtagonista> findAllProtas(int id){
        return peliculaProtaRepository.findAllByPeliId(id);
    }
}
