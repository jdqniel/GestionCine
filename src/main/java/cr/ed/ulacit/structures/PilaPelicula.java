package cr.ed.ulacit.structures;

import cr.ed.ulacit.model.Pelicula;

public class PilaPelicula {
    private class Node {
        Pelicula data;
        Node next;

        Node(Pelicula data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    public PilaPelicula() {
        this.top = null;
        this.size = 0;
    }

    public void push(Pelicula movie) {
        Node newNode = new Node(movie);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Pelicula pop() {
        if (isEmpty()) {
            return null;
        }

        Pelicula movie = top.data;
        top = top.next;
        size--;
        return movie;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}