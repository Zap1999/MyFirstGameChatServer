package ChatPackage;

import java.io.Serializable;

public class MessageCollection implements Collection, Serializable {

    private static final long serialVersionUID = 6529685098267757690L;

    public static final int MAX_ITEMS = 999;

    private int count = 0;

    private Message[] msgList;

    public MessageCollection() {
        msgList = new Message[MAX_ITEMS];
    }

    public int getCount() {
        return count;
    }

    public void add(Message m) throws RuntimeException {

        if(count >= MAX_ITEMS) {
            System.err.println("Message collection overflow.");
            throw new RuntimeException("Collection overflow");
        }
        else {
            msgList[count] = m;
            count++;
        }

    }

    @Override
    public Iterator createIterator() {
        return new MessageCollectionIterator(msgList);
    }


}
