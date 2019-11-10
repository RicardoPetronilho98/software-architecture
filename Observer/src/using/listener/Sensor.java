package using.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import java.util.Random;

public class Sensor {

    public String id;
    private EventListenerList listenerList;

    public Sensor(String id) {
        this.id = id;
        this.listenerList = new EventListenerList();
    }

    public void addListener(ChangeListener l) {
        this.listenerList.add(ChangeListener.class, l);
    }

    public void removeListener(ChangeListener l) {
        this.listenerList.remove(ChangeListener.class, l);
    }

    protected void fireChange(Object o) {
        for (ChangeListener l: listenerList.getListeners(ChangeListener.class)) {
            l.stateChanged(new ChangeEvent(o));
        }
    }

    /** Activates this sensor and simulates temperature reading. */
    public void initSensor() {
        new Thread(() -> {
            Random r = new Random();
            int time = r.nextInt(4000) + 1000; /** between 1 and 5 seconds */
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int temp = r.nextInt(30) + 10; /** between 10 and 40 ºC */
            this.fireChange(new Object[]{this, temp}); /** sends temperature information to all Listeners */
        }).start();
    }
}
