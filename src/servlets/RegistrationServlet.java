package servlets;

import dao.DaoXmlUsers;
import objects.Message;
import objects.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationServlet extends HttpServlet {


    public RegistrationServlet() throws IOException {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("login");
        String pass = req.getParameter("password");
        DaoXmlUsers daoXmlUsers = new DaoXmlUsers();
        ArrayList<User> fullusers = daoXmlUsers.getUsers("D:\\users.xml");
        for (User user : fullusers) {
            if (fullusers.isEmpty()) {
                User user2 = new User(name, pass);
                daoXmlUsers.add(user2, "D:\\users.xml");
                req.getRequestDispatcher("/autorization.jsp").forward(req, resp);
            } else if (user.getName().equals(name)) {
                req.getRequestDispatcher("/registration.jsp").forward(req, resp);
            }
        }
        User user = new User(name, pass);
        daoXmlUsers.add(user, "D:\\users.xml");
        req.getRequestDispatcher("/autorization.jsp").forward(req, resp);
    }
}