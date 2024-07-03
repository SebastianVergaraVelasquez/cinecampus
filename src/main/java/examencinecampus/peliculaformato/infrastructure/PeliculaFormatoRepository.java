package examencinecampus.peliculaformato.infrastructure;

import java.util.List;

import examencinecampus.peliculaformato.domain.models.PeliculaFormato;

public interface PeliculaFormatoRepository {
    void save(PeliculaFormato peliculaFormato);
    void update(PeliculaFormato peliculaFormato);
    void delete (int id);
    List<PeliculaFormato> findAll();
}
