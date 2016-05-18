package travelplanner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class SystemController {
    public static String dbPath = "C:/Users/Administratör/workspace/GIT_JAVA/TravelPlaner/pa1415_group.e2_travelplanner.db";
	
    public String user;
    public String userName;
    private FlightController flight;
    //private EmailMock email;
    private AccountController account;
    private PaymentController pay;
    
    SystemController() {
    }
    
    public boolean login(String username, String password) throws NoSuchAlgorithmException {
        byte[] bytes;
        String[] loginReturn = new String[2];

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        bytes = md.digest();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        String hashedPassword = sb.toString();
        
        this.account = new AccountController(username, hashedPassword);
        loginReturn = account.login();
        this.user = loginReturn[0];
        this.userName = loginReturn[1];

        	System.out.println("User" + this.user + "UserName" + this.userName);
        
        boolean ret = true;
        
        if (this.user.equals("")) {
            ret = false;
        } else if(this.user.equals("ACTIVATE")){
        	this.user = null;
        	this.userName = null;
        	ret = false;
        }
        
        return ret;
    }
    
    public boolean register(String username, String password, String firstName, String lastName) throws NoSuchAlgorithmException {
        byte[] bytes;
        boolean ret = false;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        bytes = md.digest();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        String hashedPassword = sb.toString();
        
        this.account = new AccountController(username, hashedPassword);

        boolean result = account.register(firstName, lastName);

        if(result){
        	//Send activation email
        	EmailController ec = new EmailController(userName);
        	ec.sendActivate();
        	
            ret=true;
        }
        else{
            user=null;
        }
        return ret;
    }
    
    public boolean bookFlight(int id, int nrOfPassangers, String cardNr, int price) {
    	boolean success = false;
    	this.pay = new PaymentController(cardNr, price, this.user);
    	
    	if(pay.makePayment()) {
    		EmailController ec = new EmailController(this.user);
    		this.flight = new FlightController();
    		
    		ec.sendRecipt();
    		success = this.flight.bookFlight(id, nrOfPassangers);    		
    	}
    	return success;
    }
    
    public String[][] getFlights(String origin, String destination, String date) {
        this.flight = new FlightController();
        flight.removeFullBookedFlight();
        
        //System.out.println(this.flight.getFlights(origin, destination, date));
        return this.flight.getFlights(origin, destination, date);
    }
    
    public String[][] getFlights(int id) {
        this.flight = new FlightController();
        flight.removeFullBookedFlight();

        return this.flight.getFlightsInfo(id);
    }
    
    public boolean addFlight(String origin, String destination, String deptDate, String deptTime, String travelTime, int nrOfSeats) {
        this.flight = new FlightController();
        
        //return this.flight.addFlight(origin, destination, deptDate, travelTime, nrOfSeats, nrOfSeats);
        return true;
    }
    
    public boolean removeFlight(int id) {
        this.flight = new FlightController();
        
        return this.flight.removeFlight(id);
    }
    
    public boolean updateFlight(String origin, String destination, String deptDate, String deptTime, String travelTime, int nrOfSeats) {
        this.flight = new FlightController();
        
        //return this.flight.updateFlight(origin, destination, deptDate, travelTime, nrOfSeats, nrOfSeats);
        return true;
    }
}
