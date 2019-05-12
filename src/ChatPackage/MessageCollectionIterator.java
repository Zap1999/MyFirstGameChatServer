package ChatPackage;

import java.io.Serializable;

public class MessageCollectionIterator implements Iterator, Serializable {

    Message[] msgList;

    int position = 0;

    public MessageCollectionIterator(Message[] msgs) {
        msgList = msgs;
    }

    @Override
    public boolean hasNext() {
        if (position >= msgList.length ||
                msgList[position] == null)

            return false;

        else return true;
    }

    @Override
    public Object next() {
        Message enemy = msgList[position];
        position++;
        return enemy;
    }

}
