
class SecuritySensor extends Thread {
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Sensor Active: Scanning area...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Sensor Alert: System shutting down manually.");
        }
    }
}

public class Main4 {
    public static void main(String[] args) {
        SecuritySensor sensor = new SecuritySensor();
        sensor.start();

        try {
            Thread.sleep(3000);
            
            System.out.println("System status: " + sensor.isAlive());
            
            sensor.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
