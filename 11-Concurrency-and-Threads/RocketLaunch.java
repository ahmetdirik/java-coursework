
public class RocketLaunch extends Thread{
	private String missionName;
    public RocketLaunch(String missionName) {
        this.missionName = missionName;
    }
    
    @Override
    public void run() {
        try { 
        	for(int i=5;i>0;i--) {
        		System.out.println(missionName + ": T-minus " + i);
                // Pause execution for 1000 milliseconds (1 second)
                Thread.sleep(1000);
        	}
        	System.out.println(missionName + ": LIFTOFF!");
        }
        catch (InterruptedException e) {
            System.out.println(missionName + " was interrupted.");
        }
    }
    public class Main {
        public static void main(String[] args) {
            // Create two instances of RocketLaunch
            RocketLaunch apollo = new RocketLaunch("Apollo");
            RocketLaunch voyager = new RocketLaunch("Voyager");

            // Start both threads concurrently
            apollo.start();
            voyager.start();
        }
    }
}
