
public class KitchenSimulation {

    static final Object knife = new Object();
    static final Object cuttingBoard = new Object();

    static class Chef extends Thread {
        String name;

        public Chef(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                synchronized (cuttingBoard) {
                    System.out.println(name + " grabbed the Cutting Board.");
                    Thread.sleep(50);

                    synchronized (knife) {
                        System.out.println(name + " grabbed the Knife. Chopping vegetables...");
                        Thread.sleep(500);
                    }
                    
                    // DÜZELTME: Bu satır synchronized bloğunun içine alındı.
                    // Böylece Gordon bu yazıyı yazmadan kilitleri bırakmaz, Marco araya giremez.
                    System.out.println(name + " finished chopping and released tools.");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Chef chef1 = new Chef("Gordon");
        Chef chef2 = new Chef("Marco");

        chef1.start();
        chef2.start();
    }
}
