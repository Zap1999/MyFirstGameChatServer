import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;

public class Socket {

    private ServerSocket serverSocket;
    private java.net.Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Socket(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        clientSocket = serverSocket.accept();
        out = new ObjectOutputStream(clientSocket.getOutputStream());
        in = new ObjectInputStream(clientSocket.getInputStream());
    }

    public ObjectInputStream getInput() {
        return in;
    }

    public ObjectOutputStream getOutput() {
        return out;
    }

}
