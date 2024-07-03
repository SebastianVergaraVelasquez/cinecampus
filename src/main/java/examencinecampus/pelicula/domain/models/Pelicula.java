package examencinecampus.pelicula.domain.models;

public class Pelicula {
    private int id;
    private String codinterno;
    private String nombre;
    private String duracion;
    private String sinopsis;

    public Pelicula(int id, String codinterno, String nombre, String duracion, String sinopsis) {
        this.id = id;
        this.codinterno = codinterno;
        this.nombre = nombre;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
    }

    public Pelicula(String codinterno, String nombre, String duracion, String sinopsis) {
        this.codinterno = codinterno;
        this.nombre = nombre;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
    }

    public int getId() {
        return id;
    }

    public String getCodinterno() {
        return codinterno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodinterno(String codinterno) {
        this.codinterno = codinterno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }


}






