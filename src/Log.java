package src;

/**
 * Log
 */
public class Log {

    private static String sun = "Here comes the SUN, doo-dun doo-doo";
    public static String rain = "But I set fire to the RAIN";
    public static String fog = "Through the FOG like I’m S-N-double-O-P";
    public static String snow = "Let it SNOW, let it snow, let it snow";
    public static String registered = " registered to weather tower.";
    public static String unregistered = " unregistered from weather tower.";

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
        else if (msg == "unregistered")
            log = aircraft + " landing.\n"
                    +"Tower says: " + aircraft + unregistered;

        System.out.println(log);
    }
}