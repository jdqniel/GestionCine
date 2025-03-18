package cr.ed.ulacit.model;

/**
 * Clase que representa un asiento en una sala de cine.
 */
public class Asiento {
    // Número identificador del asiento
    private int numero;
    // Estado de disponibilidad del asiento
    private boolean disponible;

    /**
     * Constructor para crear un nuevo asiento.
     * @param numero Número del asiento
     * @param disponible Estado inicial de disponibilidad
     */
    public Asiento(int numero, boolean disponible) {
        this.numero = numero;
        this.disponible = disponible;
    }

    /**
     * Obtiene el número del asiento.
     * @return número del asiento
     */
    public int getNumero() { return numero; }

    /**
     * Verifica si el asiento está disponible.
     * @return true si está disponible, false si está ocupado
     */
    public boolean estaDisponible() { return disponible; }

    /**
     * Establece la disponibilidad del asiento.
     * @param disponible nuevo estado de disponibilidad
     */
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}