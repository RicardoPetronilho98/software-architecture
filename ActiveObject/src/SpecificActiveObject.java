import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class SpecificActiveObject extends GenericActiveObject implements Proxy {

    public SpecificActiveObject() {
        super();
    }

    @Override
    public Future<Long> counter() {
        FutureTask<Long> f = new FutureTask<>(() -> {
            for(int i=0; i<100000000; i++) {
                Client.val++;
            }
            return Client.val;
        });

        try {
            this.submit(f); /** submit() is expecting a Runnable however FutureTask implements Runnable too */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return f;
    }
}
