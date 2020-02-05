package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseReimbursementDAOImplementation implements ExpenseReimbursementDAO {

	private static String url = System.getenv("Training_DB_URL");
	private static String username = System.getenv("Training_DB_Username");
	private static String password = System.getenv("Training_DB_password");

	@Override
	public void employeeLogIn(String uName, String pWord) {
		// TODO Auto-generated method stub

	}

	@Override
	public void customerLogIn(String uName, String pWord) {
		// TODO Auto-generated method stub

	}

	@Override
	public void employeeSubmitReimburse(int type, double amount, String empForKey, String description) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO revature_employees (rb_emp_id, user_name, password, first_name, last_name) VALUES(null, ?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setInt(2, pword);
			ps.setString(3, fName);
			ps.setString(4, lName);
			ps.executeUpdate();
			System.out.println("You have created a new employee record.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewAllReimburseReq() {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM revature_bank_account";
			PreparedStatement prepState = connection.prepareStatement(sql);
			ResultSet revAccnts = prepState.executeQuery();
			while (revAccnts.next()) {
				int id = revAccnts.getInt("rb_acct_id");
				String accntName = revAccnts.getString("account_name");
				String accntNum = revAccnts.getString("account_number");
				int bal = revAccnts.getInt("balance");
				System.out.println(id + " " + accntName + " " + accntNum + " " + bal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean resolveReimburse(String finManForeignKey, boolean approvalStatus) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE revature_bank_account SET balance=" + balance + " WHERE rb_acct_id=" + acctID;
			PreparedStatement ps = conn.prepareStatement(sql);
			int newBalance = ps.executeUpdate();
			System.out.println("You have deposited $" + deposit + " and your new balance is $" + balance);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void viewPending() {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM revature_bank_account";
			PreparedStatement prepState = connection.prepareStatement(sql);
			ResultSet revAccnts = prepState.executeQuery();
			while (revAccnts.next()) {
				int id = revAccnts.getInt("rb_acct_id");
				String accntName = revAccnts.getString("account_name");
				String accntNum = revAccnts.getString("account_number");
				int bal = revAccnts.getInt("balance");
				System.out.println(id + " " + accntName + " " + accntNum + " " + bal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}