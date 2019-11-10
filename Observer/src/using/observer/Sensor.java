package using.observer;

import java.util.Observable;
import java.util.Random;

public class Sensor extends Observable {

    public String id;

    public Sensor(String id) {
        super();
        this.id = id;
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
            this.setChanged();
            this.notifyObservers(temp); /** sends temperature information to all Observers */
        }).start();
    }
}
