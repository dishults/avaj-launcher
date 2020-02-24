package src;

import java.util.Arrays;

/**
 * Check
 */
public class Check extends Simulator {
    
    static final String[] aircraft = new String[] {"Baloon", "JetPlane", "Helicopter"};
    private static String splitted[];

    Check(String line) throws NumberFormatException, Exception {
        splitted = line.split(" ");
        if (splitted.length != 5)
            throw new Exception("Bad number of arguments for line: \"" 
            + line + "\" (should be 5, got " + splitted.length + ')');
        type = splitted[0];
        name = splitted[1];
        longitude = Integer.parseInt(splitted[2]);
        latitude = Integer.parseInt(splitted[3]);
        height = Integer.parseInt(splitted[4]);
        input();
    }

    static void args(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java src.Simulator scenario.txt");
            System.exit(0);
        }
    }
    static void input() throws Exception, NumberFormatException {
        if (checkType() == false)
            throw new Exception("Incorrect aircraft type: \"" + type + '"');
        if (checkName() == false)
            throw new Exception("Incorrect name: \"" + name + '"');
        if (checkLongitude() == false)
            throw new NumberFormatException("Bad longitude number for " + type + ' ' + name + ": \"" + longitude + '"');
        if (checkLatitude() == false)
            throw new NumberFormatException("Bad latitude number: \"" + latitude + '"');
        if (checkHeight() == false)
            throw new NumberFormatException("Bad height number: \"" + height + '"');
    }

    static private boolean checkType() {
        return Arrays.asList(aircraft).contains(type);
    }

    private static boolean checkName() {
        return true;
    }

    private static boolean checkLongitude() {
            return longitude > 0;
    }
    
    private static boolean checkLatitude() {
            return latitude > 0;
    }
    
    private static boolean checkHeight() {
            return height >= 0;
    }
}