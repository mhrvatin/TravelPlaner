package travelplanner;



public class testFlightController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		//FlightController flightTest = new FlightController();
		//System.out.println("Book Flight - " + flightTest.bookFlight(1, 1)); CHECK
=======
		FlightController flightTest = new FlightController();
		System.out.println("Book Flight - " + flightTest.bookFlight(1, 1)); 
>>>>>>> 7e6890f55df8311ca001042ee2f58d6af0e22631
		//System.out.println("Get Flight - " + flightTest.getFlights("Malmo","Karlskrona","x","2016-06-10")); CHECK
		//System.out.println("Get Flight Info - " + flightTest.getFlightsInfo(1)); CHECK
		//System.out.println("Add Flight - " + flightTest.addFlight("x", "x", "2016-06-10", "15:02","02:00", 0, 0)); CHECK
		//System.out.println("Remove Flight - " + flightTest.removeFlight(1)); CHECK
		//System.out.println("Update Flight - " + flightTest.updateFlight(3,"TEST2", "TEST2", "2016-06-10", "15:02","02:00", 1337, 1337)); //CHECK
		AccountController accTroll = new AccountController("marcus@hrvatin.se", "DOE");
		accTroll.testDB();
		
	}

}
