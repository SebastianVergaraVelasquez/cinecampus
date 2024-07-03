package examencinecampus.pais.infrastructure;

import java.util.List;

import examencinecampus.pais.domain.models.Pais;

public interface PaisRepository {
    void save(Pais pais);
    void update(Pais pais);
    void delete (int id);
    List<Pais> findAll();
}
