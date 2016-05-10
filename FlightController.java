/**
 * 
 */
package flightController;

public class flightController {
	public flightController(){
		
	}
	
	public boolean bookFlight(int id, int nrOfPassengers){
		return true;

	}
	
	public String[][] getFlights(String origin, String destination, String returnDate, String date){
		//String[][] allFlights = new String[x][y];
				String[][] sa1 = new String[4][5];
		for(int i = 0; i < sa1.length; i++) {           // sa1.length == 4
		    for (int j = 0; j < sa1[i].length; j++) {     //sa1[i].length == 5
		        sa1[i][j] = "new String value";
		    }
		}
		
		for(String item[] : sa1){
			System.out.println(item[0]);
		}
		return sa1;
		
	}
	
	public String[] getFlightsInfo(int id){
		String[] x = null;
		return x;
	}
	
	public boolean addFlight(String origin, String destination, String deptDate, String travelTime, int price,int seats){
		return false;
	}
	
	public boolean removeFlight(int id){
		return false;
	}
	
	public boolean updateFlight(String origin, String destination, String deptDate, String travelTime, int price,int seats){
		return false;
	}
	
	@SuppressWarnings("unused")
	private boolean addToDatabase(String origin, String destination, String deptDate, String travelTime, int price,int seats){
		return false;
	}
	
	@SuppressWarnings("unused")
	private boolean deleteFromDatabase(int id){
		return false;
	}
	
	@SuppressWarnings("unused")
	private boolean updateDatabase(String origin, String destination, String deptDate, String travelTime, int price,int seats){
		return false;
	}
}
