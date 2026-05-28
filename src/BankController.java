import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class BankController {

    void addAccount(int accNo,
                    String name,
                    double balance) {

        try {

            Connection con =
                DBConnection.getConnection();

            String query =
                "INSERT INTO account VALUES(?,?,?)";

            PreparedStatement pst =
                con.prepareStatement(query);

            pst.setInt(1, accNo);
            pst.setString(2, name);
            pst.setDouble(3, balance);

            int rows = pst.executeUpdate();

            if(rows > 0) {

                System.out.println(
                    "Account Added Successfully");
            }

        } catch(Exception e) {

            System.out.println(e);
        }
    }

    void displayAccounts() {

        try {

            Connection con =
                DBConnection.getConnection();

            String query =
                "SELECT * FROM account";

            PreparedStatement pst =
                con.prepareStatement(query);

            ResultSet rs =
                pst.executeQuery();

            while(rs.next()) {

                System.out.println(
                    rs.getInt(1) + " "
                    + rs.getString(2) + " "
                    + rs.getDouble(3));
            }

        } catch(Exception e) {

            System.out.println(e);
        }
    }

    void deposit(int accNo,
                 double amount) {

        try {

            Connection con =
                DBConnection.getConnection();

            String query =
                "UPDATE account "
              + "SET balance = balance + ? "
              + "WHERE accNo = ?";

            PreparedStatement pst =
                con.prepareStatement(query);

            pst.setDouble(1, amount);
            pst.setInt(2, accNo);

            int rows =
                pst.executeUpdate();

            if(rows > 0)

                System.out.println(
                    "Amount Deposited");

            else

                System.out.println(
                    "Account Not Found");

        } catch(Exception e) {

            System.out.println(e);
        }
    }

    void withdraw(int accNo,
                  double amount) {

        try {

            Connection con =
                DBConnection.getConnection();

            String query =
                "UPDATE account "
              + "SET balance = balance - ? "
              + "WHERE accNo = ? "
              + "AND balance >= ?";

            PreparedStatement pst =
                con.prepareStatement(query);

            pst.setDouble(1, amount);
            pst.setInt(2, accNo);
            pst.setDouble(3, amount);

            int rows =
                pst.executeUpdate();

            if(rows > 0)

                System.out.println(
                    "Withdrawal Successful");

            else

                System.out.println(
                    "Insufficient Balance "
                  + "or Account Not Found");

        } catch(Exception e) {

            System.out.println(e);
        }
    }
}