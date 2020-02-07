package com.revature.servlet;

import com.revature.DAO.ExpenseReimbursementDAOImplementation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");

        if (((ExpenseReimbursementDAOImplementation) request.getServletContext().getAttribute("db")).login(username, request.getParameter("password"))) {
            response.getWriter().println("/resources/SubmitReimburse.html");
            request.getSession().setAttribute("username", username);
            request.getSession().setMaxInactiveInterval(5 * 60);
        } else {
            response.getWriter().print("Failed!");
        }
    }
}