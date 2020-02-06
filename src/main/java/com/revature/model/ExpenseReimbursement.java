package com.revature.model;

import java.sql.Date;

public class ExpenseReimbursement {
	
	int expenseReimburseType;
	String firstName;
	String lasgtName;
	String reimbursementType;
	double expenseReimburseAmount;
	java.sql.Date submitDate;
	java.sql.Date decisionDate;
	int status;
	String expenseReimburseDescription;
	
	public ExpenseReimbursement() {
		super();
	}

	public ExpenseReimbursement(int expenseReimburseType, String firstName, String lasgtName, String reimbursementType,
			double expenseReimburseAmount, Date submitDate, Date decisionDate, int status,
			String expenseReimburseDescription) {
		super();
		this.expenseReimburseType = expenseReimburseType;
		this.firstName = firstName;
		this.lasgtName = lasgtName;
		this.reimbursementType = reimbursementType;
		this.expenseReimburseAmount = expenseReimburseAmount;
		this.submitDate = submitDate;
		this.decisionDate = decisionDate;
		this.status = status;
		this.expenseReimburseDescription = expenseReimburseDescription;
	}

	@Override
	public String toString() {
		return "ExpenseReimbursement [expenseReimburseType=" + expenseReimburseType + ", firstName=" + firstName
				+ ", lasgtName=" + lasgtName + ", reimbursementType=" + reimbursementType + ", expenseReimburseAmount="
				+ expenseReimburseAmount + ", submitDate=" + submitDate + ", decisionDate=" + decisionDate + ", status="
				+ status + ", expenseReimburseDescription=" + expenseReimburseDescription + "]";
	}

	public int getExpenseReimburseType() {
		return expenseReimburseType;
	}

	public void setExpenseReimburseType(int expenseReimburseType) {
		this.expenseReimburseType = expenseReimburseType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasgtName() {
		return lasgtName;
	}

	public void setLasgtName(String lasgtName) {
		this.lasgtName = lasgtName;
	}

	public String getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	public double getExpenseReimburseAmount() {
		return expenseReimburseAmount;
	}

	public void setExpenseReimburseAmount(double expenseReimburseAmount) {
		this.expenseReimburseAmount = expenseReimburseAmount;
	}

	public java.sql.Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(java.sql.Date submitDate) {
		this.submitDate = submitDate;
	}

	public java.sql.Date getDecisionDate() {
		return decisionDate;
	}

	public void setDecisionDate(java.sql.Date decisionDate) {
		this.decisionDate = decisionDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getExpenseReimburseDescription() {
		return expenseReimburseDescription;
	}

	public void setExpenseReimburseDescription(String expenseReimburseDescription) {
		this.expenseReimburseDescription = expenseReimburseDescription;
	}
	
}