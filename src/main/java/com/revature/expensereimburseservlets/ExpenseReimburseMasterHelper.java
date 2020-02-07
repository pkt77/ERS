package com.revature.expensereimburseservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExpenseReimburseMasterHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) {
    	
    	System.out.println(request.getRequestURI());
    	
    	switch(request).getURI()) {
    	
    	//case "/HomeController":
    		
    	//break;
    	case "/LoginController":
    			
    	break;
    	case "/SubmitReimburseController":
    	break;
    	case "/SubmitMoreReimburse":
    	break;
    	case "/ResolveReimburseController":
    	break;
    	case "/ResolveMoreReimburseController":
    	break;
    	
    	}
    }
}
