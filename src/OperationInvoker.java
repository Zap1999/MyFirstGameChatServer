import ChatPackage.MessageOperation;

import java.util.ArrayList;

public class OperationInvoker {

    private static ArrayList<MessageOperation> list = new ArrayList<>();

    public static ArrayList invoke(MessageOperation op, ArrayList collection) {
        list.add(op);
        return op.execute(collection);
    }

}
