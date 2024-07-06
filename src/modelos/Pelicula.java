package modelos;

public class Pelicula extends Titulo{

    private String director;

    public Pelicula(String pelicula, int fechaDeLanzamiento) {
        super(pelicula, fechaDeLanzamiento);
    }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
}
