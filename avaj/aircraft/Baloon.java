package avaj.aircraft;

import avaj.simulator.Log;
import avaj.simulator.WeatherTower;
/**
 * Baloon
 */
public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();
        String baloon = "Baloon#"+name+"("+id+")";

        Log.message(baloon + ": ", weather);
        if (weather == "SUN")
            coordinates = new Coordinates(longitude + 2, latitude, height + 4);
        else if (weather == "RAIN")
            coordinates = new Coordinates(longitude, latitude, height - 5);
        else if (weather == "FOG")
            coordinates = new Coordinates(longitude, latitude, height - 3);
        else if (weather == "SNOW")
            coordinates = new Coordinates(longitude, latitude, height - 15);
        if (coordinates.getHeight() == 0)
            unregisterTower(baloon, coordinates);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Log.message("Baloon#"+name+"("+id+")", "registered");
    }
    
    public void unregisterTower(String baloon, Coordinates coordinates) {
        this.weatherTower.unregister(this);
        Log.landing(baloon, coordinates);
    }
}