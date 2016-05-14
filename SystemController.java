package travelplanner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class SystemController {
    public static String dbPath = "e:/massa goa grejor/Skola/PA1415/" +
        "TravelPlanner_netbeans.project/travelplanner/src/TravelPlanner/" +
        "pa1415_group.e2_travelplanner.db";
	
    public String user;
    private FlightController flight;
    //private EmailMock email;
    private AccountController account;
    private PaymentController pay;
    
    SystemController() {
    }
    
    public boolean login(String username, String password) throws NoSuchAlgorithmException {
        byte[] bytes;

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        bytes = md.digest();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        String hashedPassword = sb.toString();
        
        this.account = new AccountController(username, hashedPassword);
        this.user = account.login();
        
        boolean ret = true;
        
        if (this.user.equals("")) {
            ret = false;
        }
        
        return ret;
    }
    
    public void register(String username, String password, String firstName, String lastName) throws NoSuchAlgorithmException {
        byte[] bytes;

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
    }
    
    public boolean bookFlight(int id, int nrOfPassangers, int cardNr) {
        this.flight = new FlightController();
        
        return this.flight.bookFlight(id, nrOfPassangers);
    }
    
    public ArrayList getFlights(String origin, String destination, String date) {
        this.flight = new FlightController();
        
        //System.out.println(this.flight.getFlights(origin, destination, date));
        return this.flight.getFlights(origin, destination, date);
    }
    
    public ArrayList getFlights(int id) {
        this.flight = new FlightController();
        
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
