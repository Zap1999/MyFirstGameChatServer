import ChatPackage.*;

public class Listener extends Thread {

    private Socket socket;
    private Run main;

    public Listener(Socket s, Run r) {
        socket = s;
        main = r;
    }

    @Override
    public void run() {
            System.out.println("Connected.");
            while (true) {
                MessageOperation msg;
                try {

                    msg = (MessageOperation) socket.getInput().readObject();
                    System.out.println(msg.getType());
                    Run.collection = OperationInvoker.invoke(msg, Run.collection);
                    if (msg.getType() == OpType.UPDATE) {
                        socket.getOutput().writeObject(Run.collection);
                    }
                } catch (Exception e) {
                    break;
                }
            }
    }

}
