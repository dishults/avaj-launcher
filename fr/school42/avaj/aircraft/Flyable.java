package fr.school42.avaj.aircraft;

import fr.school42.avaj.simulator.WeatherTower;

/**
 * Flyable
 */
public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}