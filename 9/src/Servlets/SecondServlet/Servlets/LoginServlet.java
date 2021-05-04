package Servlets.SecondServlet.Servlets;

import Servlets.SecondServlet.Model.User;
import Servlets.SecondServlet.Model.UsersJson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String login = request.getParameter("login");
        String password = String.valueOf(request.getParameter("password").hashCode());
        PrintWriter writer = response.getWriter();
        PrintWriter out = response.getWriter();
        try {
            UsersJson usersJson = new UsersJson();
            if(usersJson.checkUser(new User(login, password))) {
                response.addCookie(new Cookie(login, password));
                response.sendRedirect("main.jsp");
                writer.println("<h1> Добро пожаловать! <h1>");
            }
            else {
                writer.println("Такого пользователя не существует или данные ошибочны");
            }
        } finally {
            writer.println();
            writer.close();
            out.close();
        }
    }
}
