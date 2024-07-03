package examencinecampus.peliculaprotagonista.domain.models;

public class PeliculaProtagonista {
    private int id;
    private int idPelicula;
    private int idActor;
    private int idTipoActor;

    
    public PeliculaProtagonista(int id, int idPelicula, int idActor, int idTipoActor) {
        this.id = id;
        this.idPelicula = idPelicula;
        this.idActor = idActor;
        this.idTipoActor = idTipoActor;
    }

    public PeliculaProtagonista(int idPelicula, int idActor, int idTipoActor) {
        this.idPelicula = idPelicula;
        this.idActor = idActor;
        this.idTipoActor = idTipoActor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getIdPelicula() {
        return idPelicula;
    }
    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }
    public int getIdActor() {
        return idActor;
    }
    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }
    public int getIdTipoActor() {
        return idTipoActor;
    }
    public void setIdTipoActor(int idTipoActor) {
        this.idTipoActor = idTipoActor;
    }

    
}
