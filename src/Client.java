import ChatPackage.MessageOperation;

public class Client {

    private Socket clientSocket;
    private ClientMediator mediator;

    public Client(Socket socket, ClientMediator mediator) {
        clientSocket = socket;
        this.mediator = mediator;
        listenOrigin();
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    private void listenOrigin() {
        new Thread(() -> {
            MessageOperation operation;
            while(true) {
                try {
                    operation = (MessageOperation) clientSocket.getInput().readObject();
                    mediator.receive(operation);
                } catch (Exception e) {
                    mediator.disconnectClient(this);
                }

            }
        }).start();
    }

}
