package src;

/**
 * JetPlane
 */
public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();
        String jetPlane = "JetPlane#"+name+"("+id+")";

        Log.message(jetPlane + ": ", weather);
        if (weather == "SUN")
            coordinates = new Coordinates(longitude + 10, latitude, height + 2);
        else if (weather == "RAIN")
            coordinates = new Coordinates(longitude + 5, latitude, height);
        else if (weather == "FOG")
            coordinates = new Coordinates(longitude + 1, latitude, height);
        else if (weather == "SNOW")
            coordinates = new Coordinates(longitude, latitude, height - 7);
        if (coordinates.getHeight() == 0)
            unregisterTower(jetPlane, coordinates);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Log.message("JetPlane#"+name+"("+id+")", "registered");
    }

    public void unregisterTower(String jetPlane, Coordinates coordinates) {
        this.weatherTower.unregister(this);
        Log.landing(jetPlane, coordinates);
    }
}