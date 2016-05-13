import java.sql.*;

public class PaymentController{
    String dbPath = "/home/freak/TravelPlanner/pa1415_group.e2_travelplanner.db";
    private BankMock bank;
    private String user;
    private int cardNr;
    private int price;
    public PaymentController(){
        bank=new BankMock();
        cardNr=0;
        price=0;
        user="";
    }
    public PaymentController(int cardNr, int price, String user){
        bank=new BankMock();
        this.cardNr=cardNr;
        this.price=price;
        this.user=user;
    }
    public Boolean makePayment() {
        Boolean payed=false;
        if(cardNr != 0 && user==""){
           payed = bank.makePayment(cardNr,price);
        }
        if(payed){
            logTranscation();
        }
        return payed;
    }
    private Boolean logTranscation(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.executeUpdate("INSERT INTO bank VALUES (" + cardNr +"," + price +"," + user +")");
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

        return true;
    }
}

