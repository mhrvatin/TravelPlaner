/**
 * 
 */
package travelplanner;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class FlightController {
	
	
	
	private void dbConnection(String SQL){
		Connection connection = null;

		try {
		    String dbPath = "C:/cygwin64/home/david/projekt/travelplanner/src/travelplanner/pa1415_group.e2_travelplanner.db";
		    connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
		    Statement statement = connection.createStatement();
		    statement.setQueryTimeout(30);  // set timeout to 30 sec.
		    ResultSet rs = statement.executeQuery("SELECT * FROM flights");
		    if(SQL == ""){
		    	
		    }else{
		    	statement.executeUpdate(SQL);
		    }
		    

		    while(rs.next()) {
		        // read the result set
		        System.out.println("user_id = " + rs.getString("origin"));
		        /*System.out.println("user_name = " + rs.getString("user_name"));
		        System.out.println("first_name = " + rs.getString("first_name"));
		        System.out.println("last_name = " + rs.getString("last_name"));
		        System.out.println("email = " + rs.getString("email"));
		        System.out.println("user_password_hash = " + rs.getString("user_password_hash"));*/
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
	
	public FlightController(){
		this.dbConnection("");
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
		
		
		return this.addToDatabase(origin, destination,"deptTime", deptDate, travelTime, price, seats);
		
	}
	
	public boolean removeFlight(int id){
		return this.deleteFromDatabase(id);
	}
	
	public boolean updateFlight(String origin, String destination, String deptDate, String travelTime, int price,int seats){
		return this.updateDatabase(origin, destination, deptDate, travelTime, price, seats);
	}
	

	private boolean addToDatabase(String origin, String destination,String deptTime, String deptDate, String travelTime, int price,int seats){
		//INSERT INTO DATABASE
		this.dbConnection("INSERT INTO flights VALUES(2,'Malmo','Karlskrona','2016-06-10','15:02','02:00',3000,240)");
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
