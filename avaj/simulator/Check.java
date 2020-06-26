package avaj.simulator;

import java.io.File;

/**
 * Check
 */
public class Check extends Simulator {
    
    static final String[] aircraft = {"Baloon", "JetPlane", "Helicopter"};
    private static String splitted[];

    Check(String line) throws NumberFormatException, Exception {
        splitted = line.split(" ");
        if (splitted.length != 5)
            throw new Exception("Bad number of arguments for line: \"" 
            + line + "\" (should be 5, got " + splitted.length + ')');
        if (checkType() == false)
            throw new Exception("Incorrect aircraft type: \""+splitted[0]+'"');
        name = splitted[1];
        if (checkLongitude() == false)
            throw new NumberFormatException("Bad longitude number for " 
                        + type + ' ' + name + ": \"" + splitted[2] + '"');
        if (checkLatitude() == false)
            throw new NumberFormatException("Bad latitude number: \"" 
                                                        + splitted[3] + '"');
        if (checkHeight() == false)
            throw new NumberFormatException("Bad height number: \""
                                                        + splitted[4] + '"');
    }

    static void args(String[] args) {
        if (args.length != 1)
        {
            System.err.println("Usage: java simulator.Simulator scenario.txt");
            System.exit(1);
        }
    }
    static void file(File file) {
        if (file.length() == 0)
        {
            System.err.println("Your file \"" +file+ "\" appears to be empty");
            System.exit(1);
        }
    }

    static private boolean checkType() {
        if (splitted[0].equalsIgnoreCase(aircraft[0]))
        {
            type = aircraft[0];
            return true;
        }
        else if (splitted[0].equalsIgnoreCase(aircraft[1]))
        {
            type = aircraft[1];
            return true;
        }
        else if (splitted[0].equalsIgnoreCase(aircraft[2]))
        {
            type = aircraft[2];
            return true;
        }
        return false;
    }

    private static boolean checkLongitude() {
        try {
            longitude = Integer.parseInt(splitted[2]);
        } catch (NumberFormatException e) {
            return false;
        }
        return longitude > 0;
    }
    
    private static boolean checkLatitude() {
        try {
            latitude = Integer.parseInt(splitted[3]);
        } catch (NumberFormatException e) {
            return false;
        }
        return latitude > 0;
    }
    
    private static boolean checkHeight() {
        try {
            height = Integer.parseInt(splitted[4]);
        } catch (NumberFormatException e) {
            return false;
        }
        return height >= 0;
    }
}