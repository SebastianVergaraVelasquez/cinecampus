package examencinecampus.formato.application;

import java.util.List;

import examencinecampus.formato.domain.models.Formato;
import examencinecampus.formato.infrastructure.FormatoRepository;

public class FormatoService {
    private final FormatoRepository formatoRepository;

    

    public FormatoService(FormatoRepository formatoRepository) {
        this.formatoRepository = formatoRepository;
    }

    public void createFormato(Formato formato){
        formatoRepository.save(formato);
    }
    
    public void updateFormato(Formato formato){
        formatoRepository.update(formato);
    }

    public void deleteFormato(int id){
        formatoRepository.delete(id);
    }

    public List<Formato> findAllFormatos(){
        return formatoRepository.findAll();
    }
}
