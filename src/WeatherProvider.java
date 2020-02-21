package src;

/**
 * WeatherProvider
 */
public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String[] weather;
    
    private WeatherProvider() {
        weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        int change = longitude % 10 + latitude % 10 + height % 10;
        change %= 4;
        return weather[change];
    }
}