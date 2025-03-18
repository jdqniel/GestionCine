package cr.ed.ulacit.model;

public class Cliente {
    private String name;
    private String ticketNumber;
    private String arrivalTime;

    public Cliente(String name, String ticketNumber, String arrivalTime) {
        this.name = name;
        this.ticketNumber = ticketNumber;
        this.arrivalTime = arrivalTime;
    }

    public String getName() { return name; }
    public String getTicketNumber() { return ticketNumber; }
    public String getArrivalTime() { return arrivalTime; }
}