package cr.ed.ulacit.model;

public class Asiento {
    private int number;
    private boolean available;

    public Asiento(int number, boolean available) {
        this.number = number;
        this.available = available;
    }

    public int getNumber() { return number; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
