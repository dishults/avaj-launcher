package src;

/**
 * Aircraft
 */
public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        id = nextid();
        this.name = name;
        this.coordinates = coordinates;
        //System.out.println("id "+id+"\nname "+this.name+"\ncoordanates "+this.coordanates);
    }
    private long nextid() {
        return ++idCounter;
    }
}