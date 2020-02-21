package src;

/**
 * AircraftFactory
 */
public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type == "JetPlane") {
            //System.out.println("Longitude " + coordinates.getLongitude());
            //System.out.println("Latitude " + coordinates.getLatitude());
            //System.out.println("Height " + coordinates.getHeight());
            return new JetPlane(name, coordinates);
        }
        else if (type == "Helicopter")
            return new Helicopter(name, coordinates);
        else if (type == "Baloon")
            return new Baloon(name, coordinates);
        else
        {
            System.out.println("Nope");
        }
        return null;
    }
}