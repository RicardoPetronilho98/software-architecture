package using.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.Collection;

public class MSensor implements ChangeListener {

    private Collection<Sensor> sensors;

    public MSensor() {
        this.sensors = new ArrayList<>();
    }

    public void addSensor(Sensor s) {
        s.addListener(this); /** sets this manager as Listener of Sensor s */
        this.sensors.add(s);
        s.initSensor(); /** activates temperature reading (simulation) */
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        Object o = changeEvent.getSource();
        if ( o instanceof Object[] && ((Object[])o)[0] instanceof Sensor && ((Object[])o)[1] instanceof Integer ) { /** makes sure types matches */
            Sensor s = (Sensor) ((Object[])o)[0]; /** now that type is assured it can be casted safely */
            int temp = (int) ((Object[])o)[1];
            System.err.println("Sensor " + s.id + " registered " + temp + " ºC.");
        } else {
            throw new RuntimeException("Expecting class does not match!");
        }
    }
}
