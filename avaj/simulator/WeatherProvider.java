package avaj.simulator;

import avaj.aircraft.Coordinates;

/**
 * WeatherProvider
 */
public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static int n = 0;
    
    /*  Private Constructor to achieve singleton object 
    (it means only one object of the class can be created) */
    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int longitude = coordinates.getLongitude() % 10;
        int latitude = coordinates.getLatitude() % 10;
        int height = coordinates.getHeight() % 10;

        int change = longitude + latitude + height + n;
        n = (n + 1) % 100;
        return weather[change % 4];
    }
}