package com.revature.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ExpenseReimbursementDAOImplementation implements ExpenseReimbursementDAO {
	private final Connection con;

	public ExpenseReimbursementDAOImplementation() throws SQLException, IOException {
		Map<String, String> settings = new HashMap<>();
		File file = new File("db.properties");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;

		while ((line = reader.readLine()) != null) {
			String[] setting = line.split(" ");

			settings.put(setting[0], setting[1]);
			
			
		}

		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		con = DriverManager.getConnection("jdbc:oracle:thin:@" + settings.get("url") + ":1521:ORCL",
				settings.get("user"), settings.get("pass"));
	}

	@Override
	public void reimburseLogIn(String uName, String pWord) {
		/*
		 * try { String sql =
		 * "SELECT user_name, password FROM revature_customers WHERE rb_cust_id=" +
		 * customerIDInfo; PreparedStatement prepState = con.prepareStatement(sql);
		 * ResultSet revAccnts = prepState.executeQuery(); if (revAccnts.next()) {
		 * custUN = revAccnts.getString("user_name"); pwrd =
		 * revAccnts.getString("password"); if (custUN.equals(custUseNm) &&
		 * pwrd.equals(custPWRD)) { System.out.println("Thank you for logging in");
		 * return; } } System.out.println("You're login credentials are invalid");
		 * NewBankAppSwitch.showCustomerMenu();
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); }
		 */
	}

	@Override
	public void employeeSubmitReimburse(int reimburseType, double amount, String empForKey, String description) {
		try {
			String sql = "INSERT INTO reimburse(r_type, amount, sub_date, fk_emp_id, status, description) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, reimburseType);
			ps.setDouble(2, amount);
			ps.setDate(3, new Date(System.currentTimeMillis()));
			ps.setString(4, empForKey);
			ps.setInt(5, 1);
			ps.setString(6, description);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewAllReimburseReq() {
		try {
			String sql = "SELECT * FROM reimburse a INNER JOIN employee b ON b.emp_id = a.fk_emp_id";
			PreparedStatement prepstate = con.prepareStatement(sql);
			ResultSet rset = prepstate.executeQuery();
			while (rset.next()) {
				int reimbursmentID = rset.getInt("reim_id");
				String fname = rset.getString("fname");
				String lname = rset.getString("lname");
				String rtype = rset.getString("r_type");
				Double amount = rset.getDouble("amount");
				java.sql.Date sub_date = rset.getDate("sub_date");
				java.sql.Date dec_date = rset.getDate("dec_date");
				String manFK_id = rset.getString("fk_man_id");
				int status = rset.getInt("status");
				String desc = rset.getString("description");

				System.out.println("reimbursmentID:" + reimbursmentID + "\n fname: " + fname + "\n lname: " + lname
						+ "\n rtype: " + rtype + "\n amount: " + amount + "\n sub_date:" + sub_date + "\n dec_date: "
						+ dec_date + "\n man_id: " + manFK_id + "\n status: " + status + "\n desc: " + desc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void resolveReimburse(String finManForeignKey, int approvalStatus, int reimburseID) {
		try {			String sql = "UPDATE reimburse SET fk_man_id=" + "'" + finManForeignKey + "'" + ",status="  
					+ approvalStatus + " WHERE reim_id="+reimburseID;
			PreparedStatement prepstate = con.prepareStatement(sql);
			prepstate.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewPending() {
		try {
			String sql = "SELECT * FROM reimburse a INNER JOIN employee b ON b.emp_id = a.fk_emp_id WHERE status = 1";
			PreparedStatement prepstate = con.prepareStatement(sql);
			ResultSet rset = prepstate.executeQuery();
			while (rset.next()) {
				int reimbursmentID = rset.getInt("reim_id");
				String fname = rset.getString("fname");
				String lname = rset.getString("lname");
				String rtype = rset.getString("r_type");
				double amount = rset.getDouble("amount");
				java.sql.Date sub_date = rset.getDate("sub_date");
				java.sql.Date dec_date = rset.getDate("dec_date");
				String manFK_id = rset.getString("fk_man_id");
				int status = rset.getInt("status");
				String desc = rset.getString("description");

				System.out.println("reimbursmentID:" + reimbursmentID + "\n fname: " + fname + "\n lname: " + lname
						+ "\n rtype: " + rtype + "\n amount: " + amount + "\n sub_date:" + sub_date + "\n dec_date: "
						+ dec_date + "\n man_id: " + manFK_id + "\n status: " + status + "\n desc: " + desc);
			}
			prepstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}