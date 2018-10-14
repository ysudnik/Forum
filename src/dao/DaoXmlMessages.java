package dao;

import objects.AllMessages;
import objects.Message;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DaoXmlMessages {
    public void add(Message message,String PATH) {
        ArrayList<Message> messages = getMessages(PATH);
        messages.add(message);
        AllMessages allMessages = new AllMessages(messages);
        try {
            JAXBContext context = JAXBContext.newInstance(AllMessages.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(allMessages, new File(PATH));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Message> getMessages(String PATH) {
        try {
            JAXBContext context = JAXBContext.newInstance(AllMessages.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            AllMessages allMessages = (AllMessages) unmarshaller.unmarshal(new File(PATH));
            return allMessages.getAllMessages();
        } catch (JAXBException e) {
            return new ArrayList<>();
        }
    }

}
