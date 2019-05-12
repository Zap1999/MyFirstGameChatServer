import ChatPackage.Message;
import ChatPackage.MessageCollection;

import java.io.IOException;
import java.util.ArrayList;

public class Run {

    public static MessageCollection collection;

    static {
        collection  = new MessageCollection();
        collection.add(new Message("Server msg 1", "server"));
        collection.add(new Message("Server msg 2", "server"));
    }

    public void run() {
        int i = 7777;
        while (true) {
            try {
                Socket s = new Socket(i);
                s.start();
                new Listener(s, this).start();
                i++;
            } catch (IOException e) {
                System.err.println("Socket start failed.");
                e.printStackTrace();
            }

        }
    }

}
