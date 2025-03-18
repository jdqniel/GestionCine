package cr.ed.ulacit.structures;

import cr.ed.ulacit.model.Asiento;

public class ListaAsiento {
    private class Node {
        Asiento data;
        Node next;

        Node(Asiento data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public ListaAsiento() {
        this.head = null;
    }

    public void addSeat(Asiento seat) {
        Node newNode = new Node(seat);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void bookSeat(int seatNumber) {
        Node current = head;

        while (current != null) {
            if (current.data.getNumber() == seatNumber) {
                if (current.data.isAvailable()) {
                    current.data.setAvailable(false);
                    System.out.println("Asiento " + seatNumber + " reservado exitosamente.");
                } else {
                    System.out.println("El asiento " + seatNumber + " ya está ocupado.");
                }
                return;
            }
            current = current.next;
        }

        System.out.println("Asiento " + seatNumber + " no encontrado.");
    }

    public void releaseSeat(int seatNumber) {
        Node current = head;

        while (current != null) {
            if (current.data.getNumber() == seatNumber) {
                if (!current.data.isAvailable()) {
                    current.data.setAvailable(true);
                    System.out.println("Asiento " + seatNumber + " liberado exitosamente.");
                } else {
                    System.out.println("El asiento " + seatNumber + " ya está disponible.");
                }
                return;
            }
            current = current.next;
        }

        System.out.println("Asiento " + seatNumber + " no encontrado.");
    }

    public void displaySeats() {
        Node current = head;
        int count = 0;

        while (current != null) {
            System.out.print("Asiento " + current.data.getNumber() + ": " +
                    (current.data.isAvailable() ? "Disponible" : "Ocupado") + "\t");
            count++;

            if (count % 5 == 0) {
                System.out.println();
            }

            current = current.next;
        }

        System.out.println();
    }
}
