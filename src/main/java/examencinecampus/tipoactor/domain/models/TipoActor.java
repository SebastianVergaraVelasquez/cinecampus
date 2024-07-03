package examencinecampus.tipoactor.domain.models;

public class TipoActor {
    private int id;
    private String descripcion;
    public TipoActor(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    public TipoActor(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
