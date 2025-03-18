package cr.ed.ulacit.model;

import cr.ed.ulacit.structures.ColaCliente;
import cr.ed.ulacit.structures.ListaAsiento;
import cr.ed.ulacit.structures.PilaPelicula;

/**
 * Clase principal que gestiona el sistema del cine.
 * Maneja las salas, asientos, películas y clientes del cine.
 */
public class Cine {
    // Atributos principales del cine
    private String nombre;
    private PilaPelicula historialPeliculas;  // Historial de películas proyectadas
    private ColaCliente colaClientes;         // Cola de clientes esperando
    private ListaAsiento[] salasAsientos;     // Array de listas de asientos por sala

    /**
     * Constructor que inicializa un nuevo cine con sus salas y asientos.
     * @param nombre Nombre del cine
     * @param numSalas Número total de salas del cine
     * @param asientosPorSala Cantidad de asientos en cada sala
     */
    public Cine(String nombre, int numSalas, int asientosPorSala) {
        this.nombre = nombre;
        this.historialPeliculas = new PilaPelicula();
        this.colaClientes = new ColaCliente();
        this.salasAsientos = new ListaAsiento[numSalas];

        // Inicializar los asientos de cada sala
        for (int i = 0; i < numSalas; i++) {
            salasAsientos[i] = new ListaAsiento();
            for (int j = 1; j <= asientosPorSala; j++) {
                salasAsientos[i].agregarAsiento(new Asiento(j, true));
            }
        }
    }

    /**
     * Agrega una película al historial de proyecciones.
     * @param pelicula Película a agregar al historial
     */
    public void agregarPeliculaHistorial(Pelicula pelicula) {
        historialPeliculas.apilar(pelicula);
    }

    /**
     * Agrega un cliente a la cola de espera.
     * @param cliente Cliente a agregar a la cola
     */
    public void agregarClienteCola(Cliente cliente) {
        colaClientes.encolar(cliente);
    }

    /**
     * Procesa el siguiente cliente en la cola.
     * Muestra información del cliente procesado o un mensaje si la cola está vacía.
     */
    public void procesarSiguienteCliente() {
        Cliente cliente = colaClientes.desencolar();
        if (cliente != null) {
            System.out.println("Procesando cliente: " + cliente.getNombre() +
                    " con entrada número " + cliente.getNumeroEntrada());
        } else {
            System.out.println("No hay clientes en espera.");
        }
    }

    /**
     * Reserva un asiento específico en una sala.
     * @param numeroSala Número de la sala
     * @param numeroAsiento Número del asiento a reservar
     */
    public void reservarAsiento(int numeroSala, int numeroAsiento) {
        if (numeroSala > 0 && numeroSala <= salasAsientos.length) {
            salasAsientos[numeroSala - 1].reservarAsiento(numeroAsiento);
        } else {
            System.out.println("Número de sala no válido.");
        }
    }

    /**
     * Libera un asiento previamente reservado.
     * @param numeroSala Número de la sala
     * @param numeroAsiento Número del asiento a liberar
     */
    public void liberarAsiento(int numeroSala, int numeroAsiento) {
        if (numeroSala > 0 && numeroSala <= salasAsientos.length) {
            salasAsientos[numeroSala - 1].liberarAsiento(numeroAsiento);
        } else {
            System.out.println("Número de sala no válido.");
        }
    }

    /**
     * Muestra el historial completo de películas proyectadas.
     * Utiliza una pila temporal para mantener el orden original.
     */
    public void mostrarHistorialPeliculas() {
        PilaPelicula pilaTemp = new PilaPelicula();
        Pelicula pelicula;

        while ((pelicula = historialPeliculas.desapilar()) != null) {
            System.out.println("Película: " + pelicula.getNombre() +
                    ", Horario: " + pelicula.getHorario() +
                    ", Duración: " + pelicula.getDuracion() + " min, " +
                    "Sala: " + pelicula.getSala());
            pilaTemp.apilar(pelicula);
        }

        // Restaurar la pila original
        while ((pelicula = pilaTemp.desapilar()) != null) {
            historialPeliculas.apilar(pelicula);
        }
    }

    /**
     * Muestra el estado actual de los asientos en una sala específica.
     * @param numeroSala Número de la sala a consultar
     */
    public void mostrarEstadoAsientos(int numeroSala) {
        if (numeroSala > 0 && numeroSala <= salasAsientos.length) {
            System.out.println("Estado de asientos para Sala " + numeroSala + ":");
            salasAsientos[numeroSala - 1].mostrarAsientos();
        } else {
            System.out.println("Número de sala no válido.");
        }
    }

    /**
     * Muestra información general del sistema del cine.
     * Incluye nombre, número de salas y estadísticas actuales.
     */
    public void mostrarInformacionSistema() {
        System.out.println("=== Sistema de Gestión de " + nombre + " ===");
        System.out.println("Número de salas: " + salasAsientos.length);
        System.out.println("Clientes en espera: " + colaClientes.obtenerTamaño());
        System.out.println("Películas en historial: " + historialPeliculas.obtenerTamaño());
    }
}