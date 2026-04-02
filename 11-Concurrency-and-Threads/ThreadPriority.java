
class DownloadTask extends Thread {
    private String fileName;

    public DownloadTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("Downloading " + fileName + "...");
    }
}

public class Main5{
    public static void main(String[] args) {
        DownloadTask criticalPatch = new DownloadTask("System Security Patch");
        DownloadTask backgroundUpdate = new DownloadTask("Wallpaper Pack");

        criticalPatch.setPriority(Thread.MAX_PRIORITY);
        backgroundUpdate.setPriority(Thread.MIN_PRIORITY);

        criticalPatch.start();
        backgroundUpdate.start();
    }
}
