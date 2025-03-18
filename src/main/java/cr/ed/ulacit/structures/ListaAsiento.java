package cr.ed.ulacit.structures;

import cr.ed.ulacit.model.Asiento;

/**
 * Implementación de una lista enlazada para gestionar asientos.
 * Permite agregar, reservar, liberar y mostrar asientos.
 */
public class ListaAsiento {

    /**
     * Clase interna que representa un nodo en la lista.
     * Cada nodo contiene un asiento y una referencia al siguiente nodo.
     */
    private class Nodo {
        Asiento datos;
        Nodo siguiente;

        /**
         * Constructor del nodo.
         * @param datos Asiento a almacenar en el nodo
         */
        Nodo(Asiento datos) {
            this.datos = datos;
            this.siguiente = null;
        }
    }

    // Referencia al primer nodo de la lista
    private Nodo cabeza;

    /**
     * Constructor de la lista.
     * Inicializa una lista vacía.
     */
    public ListaAsiento() {
        this.cabeza = null;
    }

    /**
     * Agrega un nuevo asiento al final de la lista.
     * @param asiento Asiento a agregar
     */
    public void agregarAsiento(Asiento asiento) {
        Nodo nuevoNodo = new Nodo(asiento);

        // Si la lista está vacía, el nuevo nodo será la cabeza
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            // Si no está vacía, recorrer hasta el final y agregar el nuevo nodo
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    /**
     * Reserva un asiento específico por su número.
     * @param numeroAsiento Número del asiento a reservar
     * @return true si el asiento fue reservado exitosamente, false si no está disponible
     */
    public boolean reservarAsiento(int numeroAsiento) {
        Nodo actual = cabeza;

        // Recorrer la lista buscando el asiento
        while (actual != null) {
            if (actual.datos.getNumero() == numeroAsiento) {
                if (actual.datos.estaDisponible()) {
                    actual.datos.setDisponible(false);
                    return true;
                } else {
                    return false; // El asiento ya está ocupado
                }
            }
            actual = actual.siguiente;
        }

        return false; // No se encontró el asiento
    }

    /**
     * Libera un asiento específico por su número.
     * @param numeroAsiento Número del asiento a liberar
     * @return true si el asiento fue liberado exitosamente, false si ya estaba disponible
     */
    public boolean liberarAsiento(int numeroAsiento) {
        Nodo actual = cabeza;

        // Recorrer la lista buscando el asiento
        while (actual != null) {
            if (actual.datos.getNumero() == numeroAsiento) {
                if (!actual.datos.estaDisponible()) {
                    actual.datos.setDisponible(true);
                    return true;
                } else {
                    return false; // El asiento ya estaba disponible
                }
            }
            actual = actual.siguiente;
        }

        return false; // No se encontró el asiento
    }

    /**
     * Muestra el estado de todos los asientos en la lista.
     */
    public void mostrarAsientos() {
        if (cabeza == null) {
            System.out.println("No hay asientos en la lista.");
            return;
        }

        Nodo actual = cabeza;
        System.out.println("Estado de los asientos:");
        while (actual != null) {
            System.out.println("\uD83D\uDCBA" + actual.datos.getNumero() +
                    " - Disponible: " + actual.datos.estaDisponible());
            actual = actual.siguiente;
        }
    }

    /**
     * Verifica si un asiento específico está disponible.
     * @param numeroAsiento Número del asiento a verificar
     * @return true si el asiento está disponible, false si está ocupado o no existe
     */
    public boolean estaDisponible(int numeroAsiento) {
        Nodo actual = cabeza;

        // Recorrer la lista buscando el asiento
        while (actual != null) {
            if (actual.datos.getNumero() == numeroAsiento) {
                return actual.datos.estaDisponible();
            }
            actual = actual.siguiente;
        }

        return false; // No se encontró el asiento
    }
}