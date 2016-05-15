package travelplanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AccountController {
    private String user;
    private String password;

    public AccountController(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String login() {
        String ret = "";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + SystemController.dbPath);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery(
                "SELECT first_name, last_name, email, user_password_hash," +
                "account_active, admin  FROM users WHERE email = '" + this.user + "'");

            String pwdHash = rs.getString("user_password_hash");
            //LOGIN
            if(pwdHash.equals(password)) {
            	ret = this.user;
        		String fullName = (rs.getString("first_name") + " "
        				+ rs.getString("last_name"));
        		
            	if(rs.getString("admin").equals("1")) {
            		ret = "Admin";
            		fullName = "Admin";
            	}
            	if(rs.getString("account_active").equals("0")) {            		
            		ret = "ACTIVATE";	
            	}
            } else {
                ret = "";   //password incorrect
            }
        } catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
            ret = "";
            return ret; // return if user isn't found
        } finally {
            try {
                if(connection != null)
                connection.close();
            } catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }

        return ret;
    }

    public boolean register(String firstName, String lastName) {
        boolean success = addUserToDB(firstName, lastName);

        return success;
    }

    private boolean addUserToDB(String firstName, String lastName) {
        boolean ret = false;
        String user = this.user;
        String password = this.password;
        String activationHash = "";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + SystemController.dbPath);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            //CHECK IF A USER WITH THE EMAIL ALREADY EXISTS
            ResultSet rs = statement.executeQuery("SELECT email FROM users WHERE email = '" + this.user + "'");	

            //IF NO SUCH USER EXISTS ADD THE USER
            if( !rs.isBeforeFirst() ) {
                statement.executeUpdate("INSERT INTO users VALUES(" + null + ", " +
                    "'" + user + "', " +
                    "'" + password + "', " +
                    "'" + activationHash + "', " +
                    "'" + 0 + "', " +
                    "'" + 0 + "', " +
                    "'" + firstName + "', " +
                    "'" + lastName + "' )"); 

                ret = true;
            } else {
            	//In case of email already registered
            	//Change return for register() and addUserToDB() to String
            	//so that more info can be supplied
            	// or remove this else segment
            	ret = false;
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

        return ret;
    }
}