/**
 * 
 */
package flightController;

import java.util.Arrays;

public class flightController {
	
	public flightController(){
		
	}
	
	public boolean bookFlight(int id, int nrOfPassengers){
		return true;

	}
	
	public String[][] getFlights(String origin, String destination, String returnDate, String date){
		
		
		String[] flight = {"origin","dst","returnD","date"}; //EXTRACT FROM DATABASE, BASED ON PARAMETERS
		String[][] allFlights = new String[4][4];
		for(int i = 0; i < allFlights.length; i++) {
		    for (int j = 0; j < allFlights[i].length; j++) {     
		        allFlights[i][j] = flight[j];
		    }
		}
		
		//System.out.println(Arrays.deepToString(allFlights));
		
		
		return allFlights;
		
	}
	
	public String[] getFlightsInfo(int id){
		//EXTRACT FROM DATABASE, BASED ON PARAMETERS
		String[] flight = {"origin","dst","returnD","date"};
		return flight;
	}
	
	public boolean addFlight(String origin, String destination, String deptDate, String travelTime, int price,int seats){
		
		
		return this.addToDatabase(origin, destination, deptDate, travelTime, price, seats);
		
	}
	
	public boolean removeFlight(int id){
		return this.deleteFromDatabase(id);
	}
	
	public boolean updateFlight(String origin, String destination, String deptDate, String travelTime, int price,int seats){
		return this.updateDatabase(origin, destination, deptDate, travelTime, price, seats);
	}
	

	private boolean addToDatabase(String origin, String destination, String deptDate, String travelTime, int price,int seats){
		//INSERT INTO DATABASE
		
		return true;
	}
	
	
	private boolean deleteFromDatabase(int id){
		//DELETE FROM DATABASE
		return true;
	}
	
	
	private boolean updateDatabase(String origin, String destination, String deptDate, String travelTime, int price,int seats){
		//UPDATE DATABASE
		return true;
	}
}
