package ChatPackage;

import ChatPackage.Message;

import java.io.Serializable;

public class DeleteOperation implements MessageOperation, Serializable {

    private Message message;
    public final OpType op = OpType.DELETE;

    public DeleteOperation(Message message) {
        this.message = message;
    }

    @Override
    public MessageCollection execute(MessageCollection c) {
        MessageCollectionIterator was = (MessageCollectionIterator) c.createIterator();
        MessageCollection willBe = new MessageCollection();
        Message msg;
        while (was.hasNext()) {
            msg = (Message) was.next();
            if(!msg.equals(message)) {
                willBe.add(msg);
            }
        }
        return willBe;
    }

    @Override
    public OpType getType() {
        return op;
    }

    public Message getMessage() {
        return message;
    }

}
