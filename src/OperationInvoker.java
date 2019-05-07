import java.util.ArrayList;

public class OperationInvoker {

    private ArrayList<MessageOperation> list = new ArrayList<>();

    public void executeOperation(MessageOperation op) {
        list.add(op);
        op.execute();
    }

}
