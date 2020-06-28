package fr.school42.avaj.simulator;

import java.util.ArrayList;

import fr.school42.avaj.aircraft.Flyable;

/**
 * Tower
 */
public class Tower {

    private ArrayList <Flyable> observers = new ArrayList <Flyable> ();
    
    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        int size = observers.size();
        int i = 0;
        while (i < observers.size()) {
            observers.get(i).updateConditions();
            if (size == observers.size())
                i++;
            else
                size = observers.size();
        }
        /*  if every aircraft has landed */
        if (observers.isEmpty()) { 
            Simulator.writer.close();
            System.exit(0);
        }    
    }
}