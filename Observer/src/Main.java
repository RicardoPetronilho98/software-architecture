public class Main {

    public static void main(String[] agrs)  {

        int N = 10; /** number of sensors */

        /** USING OBSERVABLE-OBSERVER -------------------------------------------------------------- */
        using.observer.MSensor mSensor1 = new using.observer.MSensor(); /** Sensors manager */

        for(int i=0; i<N; i++) {
            String id = Integer.toString(i);
            using.observer.Sensor s = new using.observer.Sensor(id);
            mSensor1.addSensor(s);
        }

        /** USING LISTENERS --------------------------------------------------------------------- */

        using.listener.MSensor mSensor2 = new using.listener.MSensor(); /** Sensors manager */

        for(int i=0; i<N; i++) {
            String id = Integer.toString(i);
            using.listener.Sensor s = new using.listener.Sensor(id);
            mSensor2.addSensor(s);
        }
    }
}
