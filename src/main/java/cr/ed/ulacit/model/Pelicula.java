package cr.ed.ulacit.model;

public class Pelicula {
    private String name;
    private String time;
    private int duration;
    private int room;

    public Pelicula(String name, String time, int duration, int room) {
        this.name = name;
        this.time = time;
        this.duration = duration;
        this.room = room;
    }

    public String getName() { return name; }
    public String getTime() { return time; }
    public int getDuration() { return duration; }
    public int getRoom() { return room; }
}
