package cr.ed.ulacit.structures;

import cr.ed.ulacit.model.Cliente;

/**
 * Implementación de una estructura de datos Cola para gestionar clientes.
 * Utiliza una lista enlazada para mantener el orden FIFO (First In, First Out).
 */
public class ColaCliente {

    /**
     * Clase interna que representa un nodo en la cola.
     * Cada nodo contiene un cliente y una referencia al siguiente nodo.
     */
    private class Nodo {
        Cliente datos;
        Nodo siguiente;

        /**
         * Constructor del nodo.
         * @param datos Cliente a almacenar en el nodo
         */
        Nodo(Cliente datos) {
            this.datos = datos;
            this.siguiente = null;
        }
    }

    // Referencias al primer y último elemento de la cola
    private Nodo frente;    // Referencia al primer elemento
    private Nodo ultimo;     // Referencia al último elemento
    private int tamaño;     // Cantidad de elementos en la cola

    /**
     * Constructor de la cola.
     * Inicializa una cola vacía.
     */
    public ColaCliente() {
        this.frente = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    /**
     * Agrega un nuevo cliente al ultimo de la cola.
     * @param cliente Cliente a agregar a la cola
     */
    public void encolar(Cliente cliente) {
        Nodo nuevoNodo = new Nodo(cliente);

        // Si la cola está vacía, el nuevo nodo será tanto el frente como el ultimo
        if (estaVacia()) {
            frente = nuevoNodo;
        } else {
            // Si no está vacía, el nuevo nodo se agrega al ultimo
            ultimo.siguiente = nuevoNodo;
        }

        ultimo = nuevoNodo;
        tamaño++;
    }

    /**
     * Remueve y retorna el cliente del frente de la cola.
     * @return Cliente en el frente de la cola, o null si la cola está vacía
     */
    public Cliente desencolar() {
        // Verificar si la cola está vacía
        if (estaVacia()) {
            return null;
        }

        // Obtener el cliente del frente
        Cliente cliente = frente.datos;

        // Mover el frente al siguiente nodo
        frente = frente.siguiente;

        // Si después de desencolar la cola queda vacía, actualizar la referencia ultimo
        if (frente == null) {
            ultimo = null;
        }

        tamaño--;
        return cliente;
    }

    /**
     * Verifica si la cola está vacía.
     * @return true si la cola está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return frente == null;
    }

    /**
     * Obtiene la cantidad de clientes en la cola.
     * @return número de clientes en la cola
     */
    public int obtenerTamaño() {
        return tamaño;
    }

    /**
     * Muestra el estado actual de la cola.
     * Útil para depuración y monitoreo.
     */
    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return;
        }

        Nodo actual = frente;
        System.out.println("Estado actual de la cola:");
        while (actual != null) {
            System.out.println("Cliente: " + actual.datos.getNombre() +
                    ", Entrada: " + actual.datos.getNumeroEntrada() +
                    ", Llegada: " + actual.datos.getHoraLlegada());
            actual = actual.siguiente;
        }
    }

    /**
     * Verifica si un cliente específico está en la cola.
     * @param numeroEntrada número de entrada a buscar
     * @return true si el cliente está en la cola, false en caso contrario
     */
    public boolean buscarCliente(String numeroEntrada) {
        Nodo actual = frente;
        while (actual != null) {
            if (actual.datos.getNumeroEntrada().equals(numeroEntrada)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    /**
     * Limpia la cola, eliminando todos los elementos.
     */
    public void limpiarCola() {
        frente = null;
        ultimo = null;
        tamaño = 0;
    }
}