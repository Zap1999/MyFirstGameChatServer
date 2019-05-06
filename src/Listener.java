import ChatPackage.Message;

public class Listener extends Thread {

    private Socket socket;

    public Listener(Socket s) {
        socket = s;
    }

    @Override
    public void run() {
            System.out.println("Connected.");
            while(true) {
                Message msg;
                try {
                    msg = (Message) socket.getInput().readObject();
                    System.out.println(msg.getText());
                } catch (Exception e) {
                    break;
                }
            }
    }

}
