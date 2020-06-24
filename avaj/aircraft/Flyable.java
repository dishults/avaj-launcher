package avaj.aircraft;

import avaj.simulator.WeatherTower;

/**
 * Flyable
 */
public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}