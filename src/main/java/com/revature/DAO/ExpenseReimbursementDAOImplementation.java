package com.revature.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.revature.NewBankAppSwitch;

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
        con = DriverManager.getConnection("jdbc:oracle:thin:@" + settings.get("url") + ":1521:ORCL", settings.get("user"), settings.get("pass"));
    }

	@Override
	public void reimburseLogIn(String uName, String pWord) {
		try  {
			String sql = "SELECT user_name, password FROM revature_customers WHERE rb_cust_id=" + customerIDInfo;
			PreparedStatement prepState = con.prepareStatement(sql);
			ResultSet revAccnts = prepState.executeQuery();
			if (revAccnts.next()) {
				custUN = revAccnts.getString("user_name");
				pwrd = revAccnts.getString("password");
				if (custUN.equals(custUseNm) && pwrd.equals(custPWRD)) {
					System.out.println("Thank you for logging in");
					return;
				}
			}
			System.out.println("You're login credentials are invalid");
			NewBankAppSwitch.showCustomerMenu();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    @Override
    public void employeeSubmitReimburse(int type, double amount, String empForKey, String description) {
        try {
            String sql = "INSERT INTO revature_employees (rb_emp_id, user_name, password, first_name, last_name) VALUES(null, ?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
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
        try {
            String sql = "SELECT * FROM revature_bank_account";
            PreparedStatement prepState = con.prepareStatement(sql);
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
        try {
            String sql = "UPDATE revature_bank_account SET balance=" + balance + " WHERE rb_acct_id=" + acctID;
            PreparedStatement ps = con.prepareStatement(sql);
            int newBalance = ps.executeUpdate();
            System.out.println("You have deposited $" + deposit + " and your new balance is $" + balance);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void viewPending() {
        try {
            String sql = "SELECT * FROM revature_bank_account";
            PreparedStatement prepState = con.prepareStatement(sql);
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