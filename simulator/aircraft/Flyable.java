package simulator.aircraft;

import simulator.WeatherTower;

/**
 * Flyable
 */
public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}