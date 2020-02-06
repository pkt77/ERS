package com.revature.driver;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.DAO.ExpenseReimbursementDAO;
import com.revature.DAO.ExpenseReimbursementDAOImplementation;

public class MainDriver {

	public static void main(String[] args) throws SQLException, IOException {
		ExpenseReimbursementDAO object = new ExpenseReimbursementDAOImplementation();
		object.viewAllReimburseReq();
		//object.viewPending();
		//object.employeeSubmitReimburse(4, 85.95, "emp2", "conference in Tempe");
		//object.resolveReimburse("man1", 0, 54);
	}
}
