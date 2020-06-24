package avaj.simulator;

import avaj.aircraft.Coordinates;

/**
 * WeatherProvider
 */
public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String[] weather;
    private static int n = 0;
    
    private WeatherProvider() {
        weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
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