import java.util.concurrent.Future;

public interface Proxy {

    Future<Long> counter();
}
