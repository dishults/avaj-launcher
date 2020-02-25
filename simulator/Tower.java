package simulator;

import java.util.ArrayList;
import java.util.List;

import simulator.aircraft.Flyable;

/**
 * Tower
 */
public class Tower {

    private List <Flyable> observers = new ArrayList <Flyable> ();
    
    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
        if (observers.isEmpty()) {//when every aircraft has landed
            Simulator.writer.close();
            System.exit(0);
        }    
    }
}