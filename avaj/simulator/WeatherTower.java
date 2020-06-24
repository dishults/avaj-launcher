package avaj.simulator;

import avaj.aircraft.Coordinates;

/**
 * WeatherTower
 */
public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        WeatherProvider weatherProvider = WeatherProvider.getProvider();
        String weather = weatherProvider.getCurrentWeather(coordinates);
        return weather;
    }

    void changeWeather() {
        conditionsChanged();
    }
}