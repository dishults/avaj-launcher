package src;

import java.io.*;

/**
 * Simulator
 */
public class Simulator {

    public static PrintWriter writer;
    private static String line;

    /* Aircraft */
    static String type;
    static String name;
    static int longitude;
    static int latitude;
    static int height;
    static Flyable aircraft;

    public static void main(String[] args) {
        //Check.args(args);
        // File readFile = new File(args[0]);
        try {
            writer = new PrintWriter("simulation.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't write to \"simulation.txt\" file");
            e.printStackTrace();
        }
        File readFile = new File("scenario.txt"); //tmp for debuging
        try (BufferedReader reader = new BufferedReader(new FileReader(readFile));) {
            int simulations = Integer.parseInt(reader.readLine());
            if (simulations <= 0)
                throw new NumberFormatException("Bad simulations number: \"" + simulations + '"');
            WeatherTower weatherTower = new WeatherTower();
            while ((line = reader.readLine()) != null)
            {
                new Check(line);
                aircraft = AircraftFactory.newAircraft(
                    type, name, longitude, latitude, height);
                aircraft.registerTower(weatherTower);
            }
            while (simulations-- > 0)
                weatherTower.changeWeather();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (NumberFormatException e) {
            System.err.println(e + " (should be one positive integer)");
        } catch (IOException e) {
            System.err.println("Something went wrong\n" + e);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            writer.close();
        }
    }
}
