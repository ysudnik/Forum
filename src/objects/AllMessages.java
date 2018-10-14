package objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
@XmlRootElement(name = "messages")
public class AllMessages {
    public AllMessages() {
    }

    private ArrayList<Message> allMessages;
    @XmlElement(name = "msg")
    public ArrayList<Message> getAllMessages() {
        return allMessages;
    }

    public void setAllMessages(ArrayList<Message> allMessages) {
        this.allMessages = allMessages;
    }

    public AllMessages(ArrayList<Message> allMessages) {
        this.allMessages = allMessages;
    }
}
