package avaj.aircraft;

import avaj.simulator.Log;
import avaj.simulator.WeatherTower;
/**
 * Helicopter
 */
public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();
        String helicopter = "Helicopter#"+name+"("+id+")";

        Log.message(helicopter + ": ", weather);
        if (weather == "SUN")
            coordinates = new Coordinates(longitude + 10, latitude, height + 2);
        else if (weather == "RAIN")
            coordinates = new Coordinates(longitude + 5, latitude, height);
        else if (weather == "FOG")        
            coordinates = new Coordinates(longitude + 1, latitude, height);
        else if (weather == "SNOW")
            coordinates = new Coordinates(longitude, latitude, height - 12);
        if (coordinates.getHeight() == 0)
            unregisterTower(helicopter, coordinates);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Log.message("Helicopter#"+name+"("+id+")", "registered");
    }

    public void unregisterTower(String helicopter, Coordinates coordinates) {
        this.weatherTower.unregister(this);
        Log.landing(helicopter, coordinates);
    }
}