package cr.ed.ulacit.model;

/**
 * Clase que representa una película en cartelera.
 */
public class Pelicula {
    private String nombre;
    private String horario;
    private int duracion;
    private int sala;

    /**
     * Constructor para crear una nueva película.
     * @param nombre Nombre de la película
     * @param horario Horario de proyección
     * @param duracion Duración en minutos
     * @param sala Número de sala
     */
    public Pelicula(String nombre, String horario, int duracion, int sala) {
        this.nombre = nombre;
        this.horario = horario;
        this.duracion = duracion;
        this.sala = sala;
    }

    public String getNombre() { return nombre; }
    public String getHorario() { return horario; }
    public int getDuracion() { return duracion; }
    public int getSala() { return sala; }
}