import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

        Client.val = 0L;
        int N = 50; /** number of clients */

        /** SYNCHRONIZATION PROTECTED BY USING ACTIVE OBJECT --------------------------------------------------------------
         * ActiveObject is a Scheduler that runs Tasks in FIFO Order with a single Thread at a time therefore it's safe to
         * work with the same object.
         * Note: LinkedBlockingQueue is concurrent safe so it can safely acquire Tasks from multiple Threads at the same time. */

        SpecificActiveObject ao = new SpecificActiveObject();

        Client[] clients = new Client[N];
        Future[] futures = new Future[N];
        for(int i=0; i<clients.length; i++) {
            clients[i] = new Client(ao);
            futures[i] = clients[i].counter();
        }
        for(Future f: futures) {
            while(f.isDone() == false) ;
            /** waits for each Task to finish its work;
             * equivalent to thread.join() */
        }

        System.out.println("synchronization protected: " + Client.val);

        /** SYNCHRONIZATION UNPROTECTED -------------------------------------------------------------------------------
         * multiple threads writing on the same object - Client.val - probably at the same time therefore there will be
         * racing conditions. */

        Client.val = 0L;
        Thread[] threads = new Thread[N];
        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(() -> {
                for(int k = 0; k <100000000; k++) { /** does the same job as client.counter() */
                    Client.val++;
                }
            });
            threads[i].start();
        }
        for(Thread th: threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("synchronization unprotected: " + Client.val);

        System.exit(1);
    }
}
