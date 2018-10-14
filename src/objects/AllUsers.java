package objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
@XmlRootElement(name = "users")
public class AllUsers {
    public AllUsers() {
    }

    private ArrayList<User> allUsers;
    @XmlElement(name = "user")
    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(ArrayList<User> allUsers) {
        this.allUsers = allUsers;
    }

    public AllUsers(ArrayList<User> allUsers) {
        this.allUsers = allUsers;
    }
}
