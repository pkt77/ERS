package com.revature.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO.ExpenseReimbursementDAOImplementation;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExpenseReimburseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(new ObjectMapper().writeValueAsString(((ExpenseReimbursementDAOImplementation) request.getServletContext().getAttribute("db")).viewPending()));
    }
}