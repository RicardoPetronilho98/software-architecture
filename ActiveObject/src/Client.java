import java.util.concurrent.Future;

public class Client implements Proxy {

    public static long val;

    private SpecificActiveObject ao;

    public Client(SpecificActiveObject ao) {
        this.ao = ao;
    }

    @Override
    public Future<Long> counter() {
        return this.ao.counter();
    }
}
