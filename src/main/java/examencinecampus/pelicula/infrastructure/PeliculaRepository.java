package examencinecampus.pelicula.infrastructure;

import java.util.List;

import examencinecampus.pelicula.domain.models.Pelicula;

public interface PeliculaRepository {
    void save(Pelicula pelicula);
    void update(Pelicula pelicula);
    void delete (int id);
    List<Pelicula> findAll();
}
