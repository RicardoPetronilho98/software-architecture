import java.util.concurrent.*;

public class GenericActiveObject {

    private BlockingQueue<Runnable> queue; /** dispatch queue */

    public GenericActiveObject() {
        this.queue = new LinkedBlockingQueue<>();
        new Thread(() -> { /** create and start Scheduler */
            while(true) { /** runs forever */
                try {
                    Runnable r = queue.take(); /** dequeue Task */
                    r.run(); /** runs Task */
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void submit(Runnable r) throws InterruptedException {
        this.queue.put(r);
    }
}