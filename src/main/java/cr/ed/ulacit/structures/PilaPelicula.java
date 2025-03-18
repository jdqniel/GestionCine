package cr.ed.ulacit.structures;

import cr.ed.ulacit.model.Pelicula;

/**
 * Implementación de una estructura de datos Pila para gestionar películas.
 * Utiliza una lista enlazada para mantener el orden LIFO (Last In, First Out).
 */
public class PilaPelicula {

    /**
     * Clase interna que representa un nodo en la pila.
     * Cada nodo contiene una película y una referencia al siguiente nodo.
     */
    private class Nodo {
        Pelicula datos;
        Nodo siguiente;

        /**
         * Constructor del nodo.
         * @param datos Película a almacenar en el nodo
         */
        Nodo(Pelicula datos) {
            this.datos = datos;
            this.siguiente = null;
        }
    }

    // Referencia al nodo superior de la pila
    private Nodo cima;
    // Contador de elementos en la pila
    private int tamaño;

    /**
     * Constructor de la pila.
     * Inicializa una pila vacía.
     */
    public PilaPelicula() {
        this.cima = null;
        this.tamaño = 0;
    }

    /**
     * Agrega una nueva película en la cima de la pila.
     * @param pelicula Película a agregar
     */
    public void apilar(Pelicula pelicula) {
        Nodo nuevoNodo = new Nodo(pelicula);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        tamaño++;
    }

    /**
     * Remueve y retorna la película de la cima de la pila.
     * @return Película en la cima de la pila, o null si la pila está vacía
     */
    public Pelicula desapilar() {
        if (estaVacia()) {
            return null;
        }

        Pelicula pelicula = cima.datos;
        cima = cima.siguiente;
        tamaño--;
        return pelicula;
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return cima == null;
    }

    /**
     * Obtiene la cantidad de películas en la pila.
     * @return número de películas en la pila
     */
    public int obtenerTamaño() {
        return tamaño;
    }

    /**
     * Muestra todas las películas en la pila, desde la cima hasta el fondo.
     */
    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("La pila está vacía");
            return;
        }

        Nodo actual = cima;
        System.out.println("Películas en la pila (desde la cima):");
        while (actual != null) {
            System.out.println("Película: " + actual.datos.getNombre() +
                    ", Horario: " + actual.datos.getHorario() +
                    ", Duración: " + actual.datos.getDuracion() +
                    ", Sala: " + actual.datos.getSala());
            actual = actual.siguiente;
        }
    }

    /**
     * Obtiene la película en la cima de la pila sin removerla.
     * @return Película en la cima, o null si la pila está vacía
     */
    public Pelicula verCima() {
        if (estaVacia()) {
            return null;
        }
        return cima.datos;
    }

    /**
     * Busca una película por su nombre en la pila.
     * @param nombre Nombre de la película a buscar
     * @return true si la película está en la pila, false en caso contrario
     */
    public boolean buscarPelicula(String nombre) {
        Nodo actual = cima;
        while (actual != null) {
            if (actual.datos.getNombre().equals(nombre)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    /**
     * Limpia la pila, eliminando todas las películas.
     */
    public void limpiarPila() {
        cima = null;
        tamaño = 0;
    }
}