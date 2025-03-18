package cr.ed.ulacit.model;

/**
 * Clase que representa un cliente del cine.
 */
public class Cliente {
    private String nombre;
    private String numeroEntrada;
    private String horaLlegada;

    /**
     * Constructor para crear un nuevo cliente.
     * @param nombre Nombre del cliente
     * @param numeroEntrada Número de entrada asignado
     * @param horaLlegada Hora de llegada al cine
     */
    public Cliente(String nombre, String numeroEntrada, String horaLlegada) {
        this.nombre = nombre;
        this.numeroEntrada = numeroEntrada;
        this.horaLlegada = horaLlegada;
    }

    public String getNombre() { return nombre; }
    public String getNumeroEntrada() { return numeroEntrada; }
    public String getHoraLlegada() { return horaLlegada; }
}