package examencinecampus.formato.infrastructure;

import java.util.List;

import examencinecampus.formato.domain.models.Formato;

public interface FormatoRepository {
    void save(Formato formato);
    void update(Formato formato);
    void delete (int id);
    List<Formato> findAll();
}
