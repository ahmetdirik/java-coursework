
import java.util.concurrent.Semaphore;

public class ServerSimulation {

    static class ConnectionPool {
        private final Semaphore semaphore;

        public ConnectionPool(int permits) {
            this.semaphore = new Semaphore(permits, true);
        }

        public void connect(String clientID) {
            try {
                System.out.println(clientID + " waiting for connection...");
                semaphore.acquire();
                
                System.out.println(clientID + " connected.");
                Thread.sleep(1000);
                
                System.out.println(clientID + " disconnecting...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    static class Client implements Runnable {
        private final ConnectionPool pool;
        private final String id;

        public Client(ConnectionPool pool, String id) {
            this.pool = pool;
            this.id = id;
        }

        @Override
        public void run() {
            pool.connect(id);
        }
    }

    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(2);

        for (int i = 1; i <= 5; i++) {
            new Thread(new Client(pool, "Client " + i)).start();
            try {
               
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}