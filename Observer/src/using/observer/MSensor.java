package using.observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

public class MSensor implements Observer {

    private Collection<Sensor> sensors;

    public MSensor() {
        this.sensors = new ArrayList<>();
    }

    public void addSensor(Sensor s) {
        s.addObserver(this); /** sets this manager as Observer of Sensor s */
        this.sensors.add(s);
        s.initSensor(); /** activates temperature reading (simulation) */
    }

    @Override
    public void update(Observable o, Object arg) {
        if ( o instanceof Sensor && arg instanceof Integer ) { /** makes sure types matches */
            Sensor s = (Sensor) o; /** now that type is assured it can be casted safely */
            int temp = (int) arg;
            System.out.println("Sensor " + s.id + " registered " + temp + " ºC.");
        } else {
            throw new RuntimeException("Expecting class does not match!");
        }
    }
}
