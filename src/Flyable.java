package src;
/**
 * Flyable
 */
public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}