import ChatPackage.*;

import java.io.IOException;
import java.util.ArrayList;

public class ClientMediator {

    private ArrayList<Message> collection;
    {
        collection  = new ArrayList<>();
        collection.add(new Message("Server msg 1", "server"));
        collection.add(new Message("Server msg 2", "server"));
    }

    private ArrayList<Client> clients;

    public ClientMediator() {
        clients = new ArrayList<>();
    }


    public void receive(MessageOperation operation) {
        collection = OperationInvoker.invoke(operation, collection);
        for(Client c : clients) {
            try {
                c.getClientSocket().getOutput().reset();
                c.getClientSocket().getOutput().writeObject(collection);
                System.out.println("New message collection:\n" + collection);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addClient(Client client) {
        clients.add(client);
        try {
            client.getClientSocket().getOutput().writeObject(collection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnectClient(Client client) {
        client.getClientSocket().stop();
        for (int i = 0; i < clients.size(); i++) {
            if (client.equals(clients.get(i))) {
                clients.remove(i);
            }
        }
    }

}
