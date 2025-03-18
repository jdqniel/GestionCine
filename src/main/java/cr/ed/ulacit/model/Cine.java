package cr.ed.ulacit.model;

import cr.ed.ulacit.structures.ColaCliente;
import cr.ed.ulacit.structures.ListaAsiento;
import cr.ed.ulacit.structures.PilaPelicula;

public class Cine {
    private String name;
    private PilaPelicula pilaPelicula;
    private ColaCliente colaCliente;
    private ListaAsiento[] listaAsientos;

    public Cine(String name, int numRooms, int seatsPerRoom) {
        this.name = name;
        this.pilaPelicula = new PilaPelicula();
        this.colaCliente = new ColaCliente();
        this.listaAsientos = new ListaAsiento[numRooms];

        // Inicializar listas de asientos para cada sala
        for (int i = 0; i < numRooms; i++) {
            listaAsientos[i] = new ListaAsiento();
            for (int j = 1; j <= seatsPerRoom; j++) {
                listaAsientos[i].addSeat(new Asiento(j, true)); // true = disponible
            }
        }
    }

    public void addMovieToHistory(Pelicula movie) {
        pilaPelicula.push(movie);
    }

    public void addCustomerToQueue(Cliente customer) {
        colaCliente.enqueue(customer);
    }

    public void processNextCustomer() {
        Cliente customer = colaCliente.dequeue();
        if (customer != null) {
            System.out.println("Procesando cliente: " + customer.getName() +
                    " con ticket " + customer.getTicketNumber());
        } else {
            System.out.println("No hay clientes en la cola.");
        }
    }

    public void bookSeat(int roomNumber, int seatNumber) {
        if (roomNumber > 0 && roomNumber <= listaAsientos.length) {
            listaAsientos[roomNumber - 1].bookSeat(seatNumber);
        } else {
            System.out.println("Número de sala inválido.");
        }
    }

    public void releaseSeat(int roomNumber, int seatNumber) {
        if (roomNumber > 0 && roomNumber <= listaAsientos.length) {
            listaAsientos[roomNumber - 1].releaseSeat(seatNumber);
        } else {
            System.out.println("Número de sala inválido.");
        }
    }

    public void displayMovieHistory() {
        PilaPelicula tempStack = new PilaPelicula();
        Pelicula movie;

        while ((movie = pilaPelicula.pop()) != null) {
            System.out.println("Película: " + movie.getName() +
                    ", Horario: " + movie.getTime() +
                    ", Duración: " + movie.getDuration() + " min, " +
                    "Sala: " + movie.getRoom());
            tempStack.push(movie);
        }

        // Restaurar la pila original
        while ((movie = tempStack.pop()) != null) {
            pilaPelicula.push(movie);
        }
    }

    public void displaySeatStatus(int roomNumber) {
        if (roomNumber > 0 && roomNumber <= listaAsientos.length) {
            System.out.println("Estado de asientos para Sala " + roomNumber + ":");
            listaAsientos[roomNumber - 1].displaySeats();
        } else {
            System.out.println("Número de sala inválido.");
        }
    }

    public void displaySystemInfo() {
        System.out.println("=== Sistema de Gestión de " + name + " ===");
        System.out.println("Número de salas: " + listaAsientos.length);
        System.out.println("Clientes en cola: " + colaCliente.size());
        System.out.println("Películas en historial: " + pilaPelicula.size());
    }
}
