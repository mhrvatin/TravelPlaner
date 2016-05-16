package travelplanner;

//TRANSCATIONS_ID???
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class PaymentController{
    private final BankMock bank;
    private final String user;
    private final int cardNr;
    private final int price;
    
    public PaymentController(){
        this.bank = new BankMock();
        this.cardNr = 0;
        this.price = 0;
        this.user = "";
    }
    public PaymentController(int cardNr, int price, String user){
        this.bank = new BankMock();
        this.cardNr = cardNr;
        this.price = price;
        this.user = user;
    }
    public Boolean makePayment() {
        boolean payed=false;
        
        if(this.cardNr != 0 && !this.user.equals("")) {
           payed = this.bank.makePayment(this.cardNr, this.price);
        }
        
        if(payed) {
            logTranscation();
        }
        
        return payed;
    }
    
    private boolean logTranscation(){
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + SystemController.dbPath);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.executeUpdate(
                "INSERT INTO transactions VALUES (" + null + ", " +
                        "'" + this.user + "', " +
                        "'" + this.price + "', " +
                        "'" + Calendar.getInstance().getTime() + "' )"
            );
            
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
        return true;
    }
}


