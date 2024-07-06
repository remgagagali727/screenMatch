package modelos;

import com.google.gson.annotations.SerializedName;
import exceptions.NoValueException;

public class Titulo {
    private String nombre;
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo(TituloOMDB tituloOMDB) {
        this.nombre = tituloOMDB.title();
        this.fechaDeLanzamiento = Integer.valueOf(tituloOMDB.year());
        if (tituloOMDB.runtime().contains("N/A")) {
            throw new NoValueException("No se pudo crear la duracion porque no existe");
        }
        this.duracionEnMinutos = Integer.valueOf(tituloOMDB.runtime().substring(0, tituloOMDB.runtime().length()-4));
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    @Override
    public String toString() {
        return "Titulo: " + this.nombre
                + ", Año: " + this.fechaDeLanzamiento
                + ", Duracion en minutos: " + this.duracionEnMinutos
                + "\n";
    }
}
