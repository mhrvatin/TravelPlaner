package travelplanner;

public class SystemController {
    public String user;
    private FlightController flight;
    private EmailMock email;
    private AccountController account;
    private PaymentController pay;
    
    SystemController() {
    }
    
    public boolean login(String username, String password) {
        this.account = new AccountController(username, password);
        
        this.user = account.login();
        
        boolean ret = false;
        
        if (this.user.equals("")) {
            ret = true;
        }
        
        return ret;
    }
    
    public void register(String username, String password, String firstName, String lastName) {
        this.account = new AccountController(username, password);
        
        boolean result = account.register(firstName, lastName);
    }
    
    public boolean bookFlight(int id, int nrOfPassangers, int cardNr) {
        this.flight = new FlightController();
        
        return this.flight.bookFlight(id, nrOfPassangers);
    }
    
    // Does not exist in FlightController
    // Should it exist?
    /*public String[][] getFlights(String origin, String destination, String date) {
        this.flight = new FlightController();
        
        return this.flight.getFlights(origin, destination, date);
    }*/
    
    public String[][] getFlights(String origin, String destination, String date, String returnDate) {
        this.flight = new FlightController();
        
        return this.flight.getFlights(origin, destination, returnDate, date);
    }
    
    public String[] getFlights(int id) {
        this.flight = new FlightController();
        
        return this.flight.getFlightsInfo(id);
    }
    
    public boolean addFlight(String origin, String destination, String deptDate, String deptTime, String travelTime, int nrOfSeats) {
        this.flight = new FlightController();
        
        return this.flight.addFlight(origin, destination, deptDate, travelTime, nrOfSeats, nrOfSeats);
    }
    
    public boolean removeFlight(int id) {
        this.flight = new FlightController();
        
        return this.flight.removeFlight(id);
    }
    
    public boolean updateFlight(String origin, String destination, String deptDate, String deptTime, String travelTime, int nrOfSeats) {
        this.flight = new FlightController();
        
        return this.flight.updateFlight(origin, destination, deptDate, travelTime, nrOfSeats, nrOfSeats);
    }
}