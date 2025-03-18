package cr.ed.ulacit;

import cr.ed.ulacit.model.Asiento;
import cr.ed.ulacit.model.Cliente;
import cr.ed.ulacit.model.Pelicula;
import cr.ed.ulacit.structures.ColaCliente;
import cr.ed.ulacit.structures.ListaAsiento;
import cr.ed.ulacit.structures.PilaPelicula;

/**
 * Demostración del Sistema de Cine con datos predefinidos
 * para mostrar la funcionalidad de las estructuras de datos
 */
public class SistemaCine {
    private final ColaCliente colaClientes;
    private final ListaAsiento listaAsientos;
    private final PilaPelicula pilaPeliculas;

    /**
     * Constructor del sistema.
     * Inicializa las estructuras y carga datos de prueba.
     */
    public SistemaCine() {
        this.colaClientes = new ColaCliente();
        this.listaAsientos = new ListaAsiento();
        this.pilaPeliculas = new PilaPelicula();

        inicializarAsientos();
        cargarDatosPrueba();
    }

    /**
     * Inicializa los asientos del cine.
     */
    private void inicializarAsientos() {
        for (int i = 1; i <= 20; i++) {
            listaAsientos.agregarAsiento(new Asiento(i, true));
        }
    }

    /**
     * Carga datos de prueba en el sistema
     */
    private void cargarDatosPrueba() {
        // Agregar clientes a la cola
        colaClientes.encolar(new Cliente("Daniel Sanchez", "101", "1400"));
        colaClientes.encolar(new Cliente("Sofia Perez", "102", "1410"));
        colaClientes.encolar(new Cliente("Juan López", "103", "1415"));
        colaClientes.encolar(new Cliente("Diego Aguilera", "104", "1420"));

        // Agregar películas a la pila
        pilaPeliculas.apilar(new Pelicula("El Señor de los Anillos", "1500", 180, 1));
        pilaPeliculas.apilar(new Pelicula("Matrix", "1700", 150, 2));
        pilaPeliculas.apilar(new Pelicula("Inception", "1900", 148, 3));

        // Reservar algunos asientos
        listaAsientos.reservarAsiento(1);
        listaAsientos.reservarAsiento(2);
        listaAsientos.reservarAsiento(15);
        listaAsientos.reservarAsiento(16);
    }

    /**
     * Demuestra las operaciones con la cola de clientes
     */
    public void demostrarOperacionesClientes() {
        System.out.println("\n=== DEMOSTRACIÓN DE COLA DE CLIENTES ===");

        // Mostrar cola inicial
        System.out.println("\nClientes en cola inicialmente:");
        colaClientes.mostrarCola();

        // Atender algunos clientes
        System.out.println("\nAtendiendo clientes:");
        Cliente clienteAtendido = colaClientes.desencolar();
        System.out.println("Cliente atendido: " + clienteAtendido.getNombre());

        // Agregar nuevo cliente
        Cliente nuevoCliente = new Cliente("Max Verstappen", "105", "1430");
        colaClientes.encolar(nuevoCliente);
        System.out.println("\nDespués de agregar un nuevo cliente:");
        colaClientes.mostrarCola();
    }

    /**
     * Demuestra las operaciones con la lista de asientos
     */
    public void demostrarOperacionesAsientos() {
        System.out.println("\n=== DEMOSTRACIÓN DE LISTA DE ASIENTOS ===");

        // Mostrar estado inicial
        System.out.println("\nEstado inicial de asientos:");
        listaAsientos.mostrarAsientos();

        // Realizar algunas operaciones
        System.out.println("\nReservando asientos 20 y 21:");
        listaAsientos.reservarAsiento(20);
        listaAsientos.reservarAsiento(21);

        System.out.println("\nLiberando asiento 1:");
        listaAsientos.liberarAsiento(1);

        System.out.println("\nEstado final de asientos:");
        listaAsientos.mostrarAsientos();
    }

    /**
     * Demuestra las operaciones con la pila de películas
     */
    public void demostrarOperacionesPeliculas() {
        System.out.println("\n=== DEMOSTRACIÓN DE PILA DE PELÍCULAS ===");

        // Mostrar pila inicial
        System.out.println("\nPelículas en cartelera inicialmente:");
        pilaPeliculas.mostrarPila();

        // Agregar nueva película
        Pelicula nuevaPelicula = new Pelicula("Avengers", "2100", 160, 1);
        pilaPeliculas.apilar(nuevaPelicula);
        System.out.println("\nDespués de agregar nueva película:");
        pilaPeliculas.mostrarPila();

        // Retirar última película
        Pelicula peliculaRetirada = pilaPeliculas.desapilar();
        System.out.println("\nPelícula retirada: " + peliculaRetirada.getNombre());
        System.out.println("\nCartelera final:");
        pilaPeliculas.mostrarPila();
    }

    /**
     * Muestra el estado general del sistema
     */
    public void mostrarEstadoSistema() {
        System.out.println("\n====== ESTADO GENERAL DEL SISTEMA ======");

        System.out.println("\n--- CLIENTES EN COLA ---");
        colaClientes.mostrarCola();

        System.out.println("\n--- ESTADO DE ASIENTOS ---");
        listaAsientos.mostrarAsientos();

        System.out.println("\n--- PELÍCULAS EN CARTELERA ---");
        pilaPeliculas.mostrarPila();
    }

    /**
     * Punto de entrada principal para la demostración
     */
    public static void main(String[] args) {
        SistemaCine sistema = new SistemaCine();

        // Ejecutar demostraciones
        sistema.mostrarEstadoSistema();
        System.out.println("\n" + "=".repeat(50));

        sistema.demostrarOperacionesClientes();
        System.out.println("\n" + "=".repeat(50));

        sistema.demostrarOperacionesAsientos();
        System.out.println("\n" + "=".repeat(50));

        sistema.demostrarOperacionesPeliculas();
        System.out.println("\n" + "=".repeat(50));

        // Mostrar estado final
        System.out.println("\nESTADO FINAL DEL SISTEMA:");
        sistema.mostrarEstadoSistema();
    }
}