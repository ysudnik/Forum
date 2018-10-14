package servlets;

import dao.DaoXmlUsers;
import objects.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AutorizationServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("login");
        String pass = req.getParameter("password");
        DaoXmlUsers daoXmlUsers = new DaoXmlUsers();
        if (daoXmlUsers.getUsers("D:\\users.xml").size() != 0) {
            List<User> fullusers = daoXmlUsers.getUsers("D:\\users.xml");
            for (User user : fullusers) {
                if (user.getName().equals(name) && user.getPass().equals(pass)) {
                    req.getServletContext().setAttribute("name", name);
                    req.getServletContext().setAttribute("password", pass);
                    req.getRequestDispatcher("/forum2.jsp").forward(req, resp);
                }
            }
        } else {
            req.getRequestDispatcher("/autorization.jsp").forward(req, resp);
        }


    }



}






