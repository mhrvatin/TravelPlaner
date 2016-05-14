
import java.sql.*;

public class BankMock {
    String dbPath = "/home/freak/TravelPlanner/pa1415_group.e2_travelplanner.db";

    BankMock() {

    }

    public Boolean makePayment(int cardNr, double price) {
        Connection connection = null;
        Boolean payed = false;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * FROM bank WHERE cardnr=" + cardNr);

            double amount = rs.getLong("amount");

            if (amount > price) {
                amount-=price;
                statement.executeUpdate("UPDATE bank set amount=" + amount +"where CardNr=" + cardNr );
                payed = true;
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
            return payed;
        }
    }
}
