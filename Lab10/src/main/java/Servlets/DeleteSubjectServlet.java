package Servlets;

import database.SubjectsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteSubjectServlet", value = "/DeleteSubjectServlet")
public class DeleteSubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            SubjectsDAO subjectsDAO = new SubjectsDAO();
            if (!subjectsDAO.Remove(id)) {
                request.setAttribute("DeleteErrorMessage", "Error while removing subject");
            }
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("ErrorCode", ex.fillInStackTrace());
            request.setAttribute("ErrorMessage", ex.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}