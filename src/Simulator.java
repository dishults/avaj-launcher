package src;

import java.io.*;

/**
 * Simulator
 */
public class Simulator {

    public static PrintWriter writer;
    private static String line;
    private static String splitted[];
    //Aircraft
    static String type;
    static String name;
    static int longitude;
    static int latitude;
    static int height;
    static Flyable aircraft;
    public static void main(String[] args) throws IOException {
        //if (args.length < 1)
        //    return;
        //File readFile = new File(args[0]);
        File readFile = new File("scenario.txt"); //tmp for debuging
        BufferedReader reader = new BufferedReader(new FileReader(readFile)); 
        writer = new PrintWriter("simulation.txt");
        int simulations = Integer.parseInt(reader.readLine());
        WeatherTower weatherTower = new WeatherTower();
                
        while ((line = reader.readLine()) != null)
        {
            splitted = line.split(" ");
            type = splitted[0];
            name = splitted[1];
            longitude = Integer.parseInt(splitted[2]);
            latitude = Integer.parseInt(splitted[3]);
            height = Integer.parseInt(splitted[4]);
            aircraft = AircraftFactory.newAircraft(
                type, name, longitude, latitude, height);
            aircraft.registerTower(weatherTower);
        }
        reader.close();
        while (simulations-- > 0)
            weatherTower.changeWeather();
        writer.close();
        return;
    }
}
