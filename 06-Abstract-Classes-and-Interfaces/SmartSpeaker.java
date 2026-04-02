interface Playable {
    void play();
}
interface Recordable {
    void record(String audioSource);
}

public class SmartSpeaker implements Playable, Recordable {
    private String deviceName;

    // Constructor
    public SmartSpeaker(String deviceName) {
        this.deviceName = deviceName;
    }

    // Implement play method
    @Override
    public void play() {
        System.out.println(deviceName + " is now playing music.");
    }

    // Implement record method
    @Override
    public void record(String audioSource) {
        System.out.println(deviceName + " is now recording from: " + audioSource + ".");
    }
    public static void main(String[] args) {
        SmartSpeaker speaker = new SmartSpeaker("Living Room Hub");

        speaker.play();  // Output: Living Room Hub is now playing music.
        speaker.record("Radio Broadcast"); // Output: Living Room Hub is now recording from: Radio Broadcast.
    }
}


