import java.io.IOException;

public class Run {

    public static boolean CHANGES  = false;

    public void run() {
        int i = 7777;
        while (true) {
            try {
                Socket s = new Socket(i);
                i++;
                s.start();
                new Listener(s, this).start();
            } catch (IOException e) {
                System.err.println("Socket start failed.");
                e.printStackTrace();
            }

        }
    }

}
