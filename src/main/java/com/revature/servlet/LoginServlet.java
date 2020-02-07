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
        if (((ExpenseReimbursementDAOImplementation) request.getServletContext().getAttribute("db")).login(request.getParameter("username"), request.getParameter("password"))) {
            response.getWriter().println("/resources/SubmitReimburse.html");
        } else {
            response.getWriter().print("Failed!");
        }
    }
}