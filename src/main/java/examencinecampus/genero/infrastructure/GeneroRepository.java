package examencinecampus.genero.infrastructure;

import java.util.List;

import examencinecampus.genero.domain.models.Genero;

public interface GeneroRepository {
    void save(Genero genero);
    void update(Genero genero);
    void delete (int id);
    List<Genero> findAll();
}
