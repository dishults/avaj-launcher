package src;

/**
 * Log
 */
public class Log {

    static final String sun = "Here comes the SUN, doo-dun doo-doo";
    static final String rain = "But I set fire to the RAIN";
    static final String fog = "Through the FOG like I’m S-N-double-O-P";
    static final String snow = "Let it SNOW, let it snow, let it snow";
    
    static final String registered = " registered to weather tower.";
    static final String unregistered = " unregistered from weather tower.";

    public static void message(String aircraft, String msg) {
        String log = new String();

        if (msg == "SUN")
            log = aircraft + sun;
        else if (msg == "RAIN")
            log = aircraft + rain;
        else if (msg == "FOG")
            log = aircraft + fog;
        else if (msg == "SNOW")
            log = aircraft + snow;
        else if (msg == "registered")
            log = "Tower says: " + aircraft + registered;
        else
            log = aircraft + msg + "\nTower says: " + aircraft + unregistered;

        System.out.println(log); //tmp
        //Simulator.writer.write(log + '\n');
    }

    public static void landing(String aircraft, Coordinates coordinates) {
        String msg = " is now landing at coordinates " 
                        + coordinates.getLongitude() + ' ' 
                        + coordinates.getLatitude() + ' ' 
                        + coordinates.getHeight();
        message(aircraft, msg);
    }
}