package com.revature.model;

public class ExpenseReimbursement {
	
	int expenseReimburseType;
	double expenseReimburseAmount;
	String employeeForeignKey;
	String finManForeignKey;
	Status status;
	String expenseReimburseDescription;
	
	public ExpenseReimbursement() {
		super();
	}

	public ExpenseReimbursement(int expenseReimburseType, double expenseReimburseAmount, String employeeForeignKey,
			String finManForeignKey, boolean status, String expenseReimburseDescription) {
		super();
		this.expenseReimburseType = expenseReimburseType;
		this.expenseReimburseAmount = expenseReimburseAmount;
		this.employeeForeignKey = employeeForeignKey;
		this.finManForeignKey = finManForeignKey;
		this.status = status;
		this.expenseReimburseDescription = expenseReimburseDescription;
	}

	@Override
	public String toString() {
		return "ExpenseReimbursement [expenseReimburseType=" + expenseReimburseType + ", expenseReimburseAmount="
				+ expenseReimburseAmount + ", employeeForeignKey=" + employeeForeignKey + ", finManForeignKey="
				+ finManForeignKey + ", status=" + status + ", expenseReimburseDescription="
				+ expenseReimburseDescription + "]";
	}

	public int getExpenseReimburseType() {
		return expenseReimburseType;
	}

	public void setExpenseReimburseType(int expenseReimburseType) {
		this.expenseReimburseType = expenseReimburseType;
	}

	public double getExpenseReimburseAmount() {
		return expenseReimburseAmount;
	}

	public void setExpenseReimburseAmount(double expenseReimburseAmount) {
		this.expenseReimburseAmount = expenseReimburseAmount;
	}

	public String getEmployeeForeignKey() {
		return employeeForeignKey;
	}

	public void setEmployeeForeignKey(String employeeForeignKey) {
		this.employeeForeignKey = employeeForeignKey;
	}

	public String getFinManForeignKey() {
		return finManForeignKey;
	}

	public void setFinManForeignKey(String finManForeignKey) {
		this.finManForeignKey = finManForeignKey;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getExpenseReimburseDescription() {
		return expenseReimburseDescription;
	}

	public void setExpenseReimburseDescription(String expenseReimburseDescription) {
		this.expenseReimburseDescription = expenseReimburseDescription;
	}
}