import ChatPackage.Message;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
    int i = 7777;
         while (true) {
                try {
                    Socket s = new Socket(i);
                    i++;
                    s.start();
                    new Listener(s).start();
                } catch (IOException e) {
                    System.err.println("Socket start failed.");
                    e.printStackTrace();
                }

            }
    }
}
