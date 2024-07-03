package examencinecampus.peliculaformato.domain.models;

public class PeliculaFormato {
    private int id;
    private int idpelicula;
    private int idformato;
    private int cantidad;
    
    public PeliculaFormato(int id, int idpelicula, int idformato, int cantidad) {
        this.id = id;
        this.idpelicula = idpelicula;
        this.idformato = idformato;
        this.cantidad = cantidad;
    }

    public PeliculaFormato(int idpelicula, int idformato, int cantidad) {
        this.idpelicula = idpelicula;
        this.idformato = idformato;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public int getIdformato() {
        return idformato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }

    public void setIdformato(int idformato) {
        this.idformato = idformato;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
