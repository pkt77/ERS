package com.revature.DAO;

import java.util.List;

import com.revature.model.ExpenseReimbursement;

public interface ExpenseReimbursementDAO {

	void reimburseLogIn(String uName, String pWord);

	void employeeSubmitReimburse (int rType, double rAmount, String empFK, String descrip);

	List<ExpenseReimbursement> viewAllReimburseReq();

	void resolveReimburse(String finManFM, int appStat, int rID);

<<<<<<< HEAD
	void viewPending();
		
	boolean login(String man_username, String man_password);
=======
	List viewPending();
>>>>>>> d4a50621e8c48865eef5040ae0b6e472cc2601c7

}