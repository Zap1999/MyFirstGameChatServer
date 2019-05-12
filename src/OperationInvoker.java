import ChatPackage.MessageCollection;
import ChatPackage.MessageOperation;

import java.util.ArrayList;

public class OperationInvoker {

    private static ArrayList<MessageOperation> list = new ArrayList<>();

    public static MessageCollection invoke(MessageOperation op, MessageCollection collection) {
        list.add(op);
        return op.execute(collection);
    }

}
