
public class InventorySystem {

    static class Inventory {
        private int stockLevel;

        public Inventory(int startLevel) {
            this.stockLevel = startLevel;
        }

        public synchronized void addToStock(int quantity) {
            stockLevel += quantity;
        }

        public synchronized void subtractFromStock(int quantity) {
            stockLevel -= quantity;
        }

        public int getStockLevel() {
            return stockLevel;
        }
    }

    static class Worker implements Runnable {
        Inventory inventory;
        boolean isStocking;

        public Worker(Inventory inventory, boolean isStocking) {
            this.inventory = inventory;
            this.isStocking = isStocking;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                if (isStocking) {
                    inventory.addToStock(1);
                } else {
                    inventory.subtractFromStock(1);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting inventory operations...");
        
        Inventory inventory = new Inventory(0);

        Thread worker1 = new Thread(new Worker(inventory, true));
        Thread worker2 = new Thread(new Worker(inventory, false));

        worker1.start();
        worker2.start();

        worker1.join();
        worker2.join();

        System.out.println("Final Stock Level: " + inventory.getStockLevel());
    }
}