package travelplanner;

import java.sql.*;

public class BankMock {
    BankMock() {

    }

    public Boolean makePayment(int cardNr, int price) {
        Connection connection = null;
        Boolean payed = false;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + SystemController.dbPath);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * FROM transcations WHERE cardnr=" + cardNr);

            int amount = rs.getInt("amount");

            if (amount > price) {
                amount-=price;
                statement.executeUpdate("UPDATE value (" + amount + ")");
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
