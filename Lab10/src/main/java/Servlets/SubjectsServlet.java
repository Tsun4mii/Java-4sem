package Servlets;

import Models.Subject;
import database.SubjectsDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SubjectsServlet", value = "/SubjectsServlet")
public class SubjectsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SubjectsDAO subjectsDAO = new SubjectsDAO();
            ArrayList<Subject> subjects = subjectsDAO.GetAll();

            request.setAttribute("subjects", subjects);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
