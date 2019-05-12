package ChatPackage;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = 7929685098267757690L;

    private String text;
    private String sender;
    public static int ID;

    public Message(String t, String s) {
        text = t;
        sender = s;
        ID++;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

}
