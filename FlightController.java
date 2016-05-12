/**
 * 
 */
package travelplanner;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FlightController {
	
	private String dbPath = "C:/cygwin64/home/david/projekt/travelplanner/src/travelplanner/pa1415_group.e2_travelplanner.db";
	//private String dbPath = "C:/cygwin/home/David/projekt/travelplanner/src/travelplanner/pa1415_group.e2_travelplanner.db";
	private boolean dbDelete(String SQL){
		Connection connection = null;
		boolean success = true;
		try {
		   
		    connection = DriverManager.getConnection("jdbc:sqlite:" + this.dbPath);
		    Statement statement = connection.createStatement();
		    statement.setQueryTimeout(30);  
		    
		    if(SQL == ""){
		    	
		    }else{
		    	statement.executeUpdate(SQL);
		    }
		    ResultSet rs = statement.executeQuery("SELECT * FROM flights");

		    while(rs.next()) {
		        // read the result set
		    	
		    }
		} catch(SQLException e) {
		    // if the error message is "out of memory",
		    // it probably means no database file is found
		    System.err.println(e.getMessage());
		    success = false;
		} finally {
		    try {
		        if(connection != null)
		        connection.close();
		    } catch(SQLException e) {
		        // connection close failed.
		        System.err.println(e);
		    }
		}
		return success;
		
	}
	
	private boolean dbInsert(String SQL){
		Connection connection = null;
		boolean success = true;
		try {
		    
		    connection = DriverManager.getConnection("jdbc:sqlite:" + this.dbPath);
		    Statement statement = connection.createStatement();
		    statement.setQueryTimeout(30);  
		    
		    if(SQL == ""){
		    	
		    }else{
		    	statement.executeUpdate(SQL);
		    }
		    ResultSet rs = statement.executeQuery("SELECT * FROM flights");

		    while(rs.next()) {
		        // read the result set
		    	
		    }
		} catch(SQLException e) {
		    // if the error message is "out of memory",
		    // it probably means no database file is found
		    System.err.println(e.getMessage());
		    success = false;
		} finally {
		    try {
		        if(connection != null)
		        connection.close();
		    } catch(SQLException e) {
		        // connection close failed.
		        System.err.println(e);
		    }
		}
		return success;
		
	}
	
	private Integer[] dbGet(String SQL){
		Connection connection = null;
		Integer flight[] = new Integer[2];
		if(SQL != ""){
			
			try {
			    
			    connection = DriverManager.getConnection("jdbc:sqlite:" + this.dbPath);
			    Statement statement = connection.createStatement();
			    statement.setQueryTimeout(30);  
			    ResultSet rs = statement.executeQuery(SQL);    
			    
			while(rs.next()) {
			        // read the result set
			        System.out.println("flight_id = " + rs.getString("flight_id"));
			        System.out.println("seats = " + rs.getString("nr_of_seats"));
			        flight[0] = rs.getInt("flight_id");
			        flight[1] = rs.getInt("nr_of_seats");
			    }
			} catch(SQLException e) {
			    // if the error message is "out of memory",
			    // it probably means no database file is found
			    System.err.println(e.getMessage());
			} finally {
				if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
			}
		}
		return flight;
	}
	
	private String[][] dbGetFlights(String SQL){
		Connection connection = null;
		String flight[][] = null;
		if(SQL != ""){
			
			try {
			    
			    connection = DriverManager.getConnection("jdbc:sqlite:" + this.dbPath);
			    Statement statement = connection.createStatement();
			    statement.setQueryTimeout(30);  
			    ResultSet rs = statement.executeQuery(SQL);   
			    flight = new String[100][8];
			    int count = 0;
			while(rs.next()) {
			        // read the result set
			       flight[count][0] = String.valueOf(rs.getInt("flight_id"));
			       flight[count][1] = String.valueOf(rs.getString("origin"));
			       flight[count][2] = String.valueOf(rs.getString("destination"));
			       flight[count][3] = String.valueOf(rs.getString("departure_date"));
			       flight[count][4] = String.valueOf(rs.getString("departure_time"));
			       flight[count][5] = String.valueOf(rs.getString("travel_time"));
			       flight[count][6] = String.valueOf(rs.getInt("price"));
			       flight[count][7] = String.valueOf(rs.getInt("nr_of_seats"));
					
			       count++;
			    }
			} catch(SQLException e) {
			    // if the error message is "out of memory",
			    // it probably means no database file is found
			    System.err.println(e.getMessage());
			} finally {
				if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
			}
		}
		return flight;
	}

	public FlightController(){
		//this.dbInsert("");
	}
	
	public boolean bookFlight(int id, int nrOfPassengers){
		
		Integer[] flight = this.dbGet("SELECT * FROM flights WHERE flight_id = "+id);
		int nrOfSeats = flight[1] - nrOfPassengers;
		
		return this.dbInsert("UPDATE FLIGHTS SET nr_of_seats = "+nrOfSeats+" WHERE flight_id = "+flight[0]);

	}
	
	public String[][] getFlights(String origin, String destination,String date){
		String[][] flights = null;
		flights = this.dbGetFlights("SELECT * FROM flights WHERE origin = '"+ origin + "' AND destination = '" + destination + "' AND departure_date = '" + date + "'" );
		
		return flights;
		
	}
	
	public String[] getFlightsInfo(int id){
		String[][] flights = null;
		flights = this.dbGetFlights("SELECT * FROM flights WHERE flight_id = "+id );
		System.out.println(flights[0][1]);
		return flights[0];	
	}
	
	public boolean addFlight(String origin, String destination, String deptDate,String deptTime, String travelTime, int price,int seats){
		return this.addToDatabase(origin, destination,deptDate, deptTime, travelTime, price, seats);
		
	}
	
	public boolean removeFlight(int id){
		return this.deleteFromDatabase(id);
	}
	
	public boolean updateFlight(int id,String origin, String destination, String deptDate,String deptTime, String travelTime, int price,int seats){
		return this.updateDatabase(id,origin, destination,deptDate, deptTime, travelTime, price, seats);
	}
	
	private boolean addToDatabase(String origin, String destination, String deptDate,String deptTime, String travelTime, int price,int seats){
		
		return this.dbInsert("INSERT INTO flights VALUES( " +
		    4 + ", " +
		    "'" + origin + "', " +
		    "'" + destination + "', " +
		    "'" + deptDate + "', " +
		    "'" + deptTime + "', " +
		    "'" + travelTime + "', " +
		    price +", " +
		    seats +
		    " )");  
		
	}
	
	private boolean deleteFromDatabase(int id){
		return this.dbDelete("DELETE FROM flights WHERE flight_id = "+ id);
	}
	
	private boolean updateDatabase(int id,String origin, String destination, String deptDate,String deptTime, String travelTime, int price,int seats){
		return this.dbInsert("UPDATE flights SET " +
				"origin = '" + origin + 
				"', destination = '" + destination + 
				"', departure_date = '" + deptDate +
				"', departure_time = '" + deptTime +
				"', travel_time = '" + travelTime +
				"', price = " + price +
				",  nr_of_seats = " + seats + 
				" WHERE flight_id = " + id);
	}
}

