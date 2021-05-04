package Servlets.SecondServlet.Servlets;

import Servlets.SecondServlet.Model.User;
import Servlets.SecondServlet.Model.UsersJson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "Registration", urlPatterns = {"/Registration"})
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String login = request.getParameter("login");
        String password = String.valueOf(request.getParameter("password").hashCode());
        PrintWriter writer = response.getWriter();
        try {
            UsersJson usersJson = new UsersJson();
            User user = new User(login, password);
            if (usersJson.getUsersFromFile().contains(user)) {
                writer.println("Аккаунт уже существует!");
            }
            else {
                usersJson.addUser(user);
                writer.println("Регистрация прошла успешно");
            }
        } catch(Exception ex) {
            writer.println(Arrays.toString(ex.getStackTrace()));
        }
    }
}
