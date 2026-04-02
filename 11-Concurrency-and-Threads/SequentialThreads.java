
class RelayRunner extends Thread {
    private String runnerName;
    private int speed;

    public RelayRunner(String runnerName, int speed) {
        this.runnerName = runnerName;
        this.speed = speed;
    }

    @Override
    public void run() {
        try {
            System.out.println(runnerName + " took the baton.");
            Thread.sleep(speed);
            System.out.println(runnerName + " passed the baton.");
        } catch (InterruptedException e) {
            System.out.println(runnerName + " interrupted.");
        }
    }
}

public class Main3 {
    public static void main(String[] args) {
        RelayRunner runner1 = new RelayRunner("Runner 1", 1000);
        RelayRunner runner2 = new RelayRunner("Runner 2", 1200);
        RelayRunner runner3 = new RelayRunner("Runner 3", 800);

        try {
            runner1.start();
            runner1.join();

            runner2.start();
            runner2.join();

            runner3.start();
            runner3.join();

            System.out.println("Race Finished!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
