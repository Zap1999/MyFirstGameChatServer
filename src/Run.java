import java.io.IOException;

public class Run {


    ClientMediator mediator = new ClientMediator();

    public void run() {
        int i = 7777;
        while (true) {
            try {
                Socket s = new Socket(i);
                s.start();
                mediator.addClient(new Client(s, mediator));
                i++;
            } catch (IOException e) {
                System.err.println("Socket start failed.");
                e.printStackTrace();
            }

        }
    }

}
