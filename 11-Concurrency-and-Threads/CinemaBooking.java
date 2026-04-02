
import java.util.concurrent.locks.ReentrantLock;

public class CinemaBooking {

    static class TicketCounter {
        private int availableSeats;
        private final ReentrantLock lock;

        public TicketCounter(int seats) {
            this.availableSeats = seats;
            this.lock = new ReentrantLock();
        }

        public void bookSeat(String customerName) {
            lock.lock();
            try {
                if (availableSeats > 0) {
                    System.out.println(customerName + " booked a seat.");
                    availableSeats--;
                    Thread.sleep(100);
                } else {
                    System.out.println(customerName + " failed to book. No seats left.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class Customer extends Thread {
        TicketCounter counter;
        String customerName;

        public Customer(TicketCounter counter, String name) {
            this.counter = counter;
            this.customerName = name;
        }

        @Override
        public void run() {
            counter.bookSeat(customerName);
        }
    }

    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter(2);

        new Customer(counter, "Alice").start();
        new Customer(counter, "Bob").start();
        new Customer(counter, "Charlie").start();
        new Customer(counter, "Dave").start();
    }
}