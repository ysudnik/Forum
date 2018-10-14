package dao;

import objects.AllMessages;
import objects.AllUsers;
import objects.Message;
import objects.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class DaoXmlUsers {
    public void add(User user, String PATH) {
        ArrayList<User> users = getUsers(PATH);
        users.add(user);
        AllUsers allUsers = new AllUsers(users);
        try {
            JAXBContext context = JAXBContext.newInstance(AllUsers.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(allUsers, new File(PATH));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<User> getUsers(String PATH) {
        try {
            JAXBContext context = JAXBContext.newInstance(AllUsers.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            AllUsers allUsers = (AllUsers) unmarshaller.unmarshal(new File(PATH));
            return allUsers.getAllUsers();
        } catch (JAXBException e) {
            return new ArrayList<>();
        }
    }
}
