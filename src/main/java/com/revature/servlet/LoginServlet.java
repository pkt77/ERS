package com.revature.servlet;

import com.revature.DAO.ExpenseReimbursementDAOImplementation;
import com.revature.Listener;
import com.revature.model.Employee;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        Employee employee = ((ExpenseReimbursementDAOImplementation) request.getServletContext().getAttribute("db")).login(username, request.getParameter("password"));

        if (employee != null) {
            request.getSession().setAttribute("employee", employee);
            request.getSession().setMaxInactiveInterval(5 * 60);

            Listener.LOGGER.warn(username + " logged in!");

            if (employee.getEmpType() == 0) {
                response.sendRedirect("/resources/SubmitReimburse.html");
            } else {
                response.sendRedirect("/resources/ResolveReimburse.html");
            }
        } else {
            Listener.LOGGER.warn(username + " failed to login!");
            response.getWriter().print("Failed!");
        }
    }
}