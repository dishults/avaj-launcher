package avaj.simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import avaj.aircraft.AircraftFactory;
import avaj.aircraft.Flyable;

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
        Check.args(args);
        File file = new File(args[0]);
        Check.file(file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file));)
        {
            int simulations = Integer.parseInt(reader.readLine());
            if (simulations <= 0)
                throw new NumberFormatException("Bad simulations number: \""
                                                    + simulations + '"');
            writer = new PrintWriter("simulation.txt");
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
        } 
        catch (FileNotFoundException e)
        {
            System.err.println(e);
        }
        catch (NumberFormatException e)
        {
            System.err.println(e + " (should be one positive integer)");
        }
        catch (IOException e)
        {
            System.err.println("Something went wrong\n" + e);
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            if (writer != null)
                writer.close();
        }
    }
}
