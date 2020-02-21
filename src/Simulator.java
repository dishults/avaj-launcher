package src;

import java.io.*;

/**
 * Simulator
 */
public class Simulator {

    public static void main(String[] args) throws IOException {
        /*if (args.length < 1)
            return;
        File readFile = new File(args[0]);
  
        BufferedReader reader = new BufferedReader(new FileReader(readFile)); 
        PrintWriter writer = new PrintWriter("simulation.txt");

        String str; 
        while ((str = reader.readLine()) != null) 
            writer.write(str + '\n');
        reader.close();
        writer.close();*/
        //AircraftFactory aircraftFactory = new AircraftFactory();
        int simulations = 3;
        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory.newAircraft("Baloon", "B1", 2, 3, 20
                ).registerTower(weatherTower);
        AircraftFactory.newAircraft("JetPlane", "J1", 23, 44, 32
                ).registerTower(weatherTower);
        AircraftFactory.newAircraft("Helicopter", "H1", 654, 33, 20
                ).registerTower(weatherTower);
        while (simulations-- > 0)
            weatherTower.changeWeather();
        return;
    }
}

//fix error after landing
//read file, write to file
//erorrs check
//unregisters from the weather tower and logs its current coordinates? logs?