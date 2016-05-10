package travelplanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SystemController {
    public String user;
    private FlightController flight;
    private EmailMock email;
    private AccountController account;
    private PaymentController pay;
    
    SystemController() {
        this.testDBConnection();
    }
    
    private void testDBConnection() {
        Connection connection = null;

        try {
            String dbPath = "FULL/PATH/TO/DB/HERE.db";
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("select * from users");

            while(rs.next()) {
                // read the result set
                System.out.println("user_id = " + rs.getString("user_id"));
                System.out.println("user_name = " + rs.getString("user_name"));
                System.out.println("first_name = " + rs.getString("first_name"));
                System.out.println("last_name = " + rs.getString("last_name"));
                System.out.println("email = " + rs.getString("email"));
                System.out.println("user_password_hash = " + rs.getString("user_password_hash"));
            }
        } catch(SQLException e) {
            // if the error message is "out of memory", 
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if(connection != null)
                connection.close();
            } catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }
    
    public boolean login(String username, String password) {
        return true;
    }
    
    public void register(String username, String password, String firstName, String lastName) {
        
    }
    
    public boolean bookFlight(int id, int nrOfPassangers, int cardNr) {
        return true;
    }
    
    public String[][] getFlights(String origin, String destination, String date) {
        return new String[10][10]; // temp values
    }
    
    public String[][] getFlights(String origin, String destination, String date, String returnDate) {
        return new String[10][10]; // temp values
    }
    
    public String[][] getFlights(int id) {
        return new String[10][10]; // temp values
    }
    
    public boolean addFlight(String origin, String destination, String deptDate, String deptTime, String travelTime, int nrOfSeats) {
        return true;
    }
    
    public boolean removeFlight(int id) {
        return true;
    }
    
    public boolean updateFlight(String origin, String destination, String deptDate, String deptTime, String travelTime, int nrOfSeats) {
        return true;
    }
}