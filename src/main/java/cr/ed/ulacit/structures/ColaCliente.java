package cr.ed.ulacit.structures;

import cr.ed.ulacit.model.Cliente;

public class ColaCliente {
    private class Node {
        Cliente data;
        Node next;

        Node(Cliente data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public ColaCliente() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(Cliente customer) {
        Node newNode = new Node(customer);

        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }

        rear = newNode;
        size++;
    }

    public Cliente dequeue() {
        if (isEmpty()) {
            return null;
        }

        Cliente customer = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;
        return customer;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}
