package examencinecampus.peliculaprotagonista.infrastructure;

import java.util.List;

import examencinecampus.peliculaprotagonista.domain.models.PeliculaProtagonista;

public interface PeliculaProtaRepository {
    void save(PeliculaProtagonista peliculaProtagonista);
    List<PeliculaProtagonista> findAllByPeliId(int id);
}
