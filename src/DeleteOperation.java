import ChatPackage.Message;

import java.io.Serializable;

public class DeleteOperation implements MessageOperation, Serializable {

    private Message message;
    public final OpType op = OpType.DELETE;

    public DeleteOperation(Message message) {
        this.message = message;
    }

    @Override
    public void execute() {

    }

    @Override
    public OpType getType() {
        return op;
    }

    public Message getMessage() {
        return message;
    }

}
