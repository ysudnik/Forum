package servlets;

import dao.DaoXmlMessages;
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
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SportServlet extends HttpServlet{

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoXmlMessages daoXmlMessages = new DaoXmlMessages();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        //1
        String nick = req.getParameter("nickname");
        String data = req.getParameter("dateParam");
        String message = req.getParameter("messageParam");

        Date date = new Date();
        Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String data2 = formatter.format(date);

        //2
        if(message != null)
        {
            User user = new User(nick);
            Message newMsg = new Message(user,message,data);
            daoXmlMessages.add(newMsg,"D:\\sportmessages.xml");
        }

        //3
        PrintWriter out = resp.getWriter();
        out.println("<h3>Ваш ник - " + nick + "<h3>");
        out.println("Сообщения: ");


        for(int i = 0; i < daoXmlMessages.getMessages("D:\\sportmessages.xml").size(); i++)
        {
            out.println("<h4>" + daoXmlMessages.getMessages("D:\\sportmessages.xml").get(i).getAuthor().getName() +
                    " : " + daoXmlMessages.getMessages("D:\\sportmessages.xml").get(i).getText() + "<h4>"
                    +"<h4>"+daoXmlMessages.getMessages("D:\\sportmessages.xml").get(i).getDate());
        }

        out.println("<hr>");

        //4
        out.println("<form action=\"/sport\"  method=\"post\">");
        out.println("<h4>" + nick + " : </h4>");
        out.println("<input type=\"text\" name=\"messageParam\"/>");
        out.println("<input type=\"hidden\" value=\"" + nick + "\" name=\"nickname\"/>");
        out.println("<input type=\"hidden\" value=\"" + data2 + "\" name=\"dateParam\"/>");
        out.println("<input type=\"submit\" value=\"send\"/>");
//        out.println("<script>");
//        out.println("function func() {");
//        out.println("document.location.href = \"http://localhost:8080/sport\"}");
//        out.println("setTimeout(func, 7000)");
//        out.println("</script>");
        out.println("</form>");
        out.println("<hr>");

        out.println("<form action=\"/auto\" method=\"post\">");
        out.println("<input type=\"hidden\" value=\"" + nick + "\" name=\"nickname\"/>");
        out.println("<input type=\"submit\" value=\"Перейти на auto\"/>");
        out.println("</form>");
        out.println("<hr>");
    }








}