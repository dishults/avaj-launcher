package fr.school42.avaj.simulator;

import fr.school42.avaj.aircraft.Coordinates;

/**
 * WeatherTower
 */
public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        conditionsChanged();
    }
}