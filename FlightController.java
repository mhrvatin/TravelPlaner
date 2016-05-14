package travelplanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlightController {
    public FlightController() {
    }
    
    private boolean dbDelete(String SQL){
        Connection connection = null;
        boolean success = true;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + SystemController.dbPath);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  

            if(!SQL.equals("")){
                statement.executeUpdate(SQL);
            }
            ResultSet rs = statement.executeQuery("SELECT * FROM flights");

            /*while(rs.next()) {
                // read the result set
            }*/
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
            connection = DriverManager.getConnection("jdbc:sqlite:" + SystemController.dbPath);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  

            if(!SQL.equals("")){
                statement.executeUpdate(SQL);
            }
            ResultSet rs = statement.executeQuery("SELECT * FROM flights");

            /*while(rs.next()) {
                // read the result set
            }*/
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

        if(!SQL.equals("")) {
            try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + SystemController.dbPath);
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
                try {
                    if(connection != null)
                        connection.close();
                } catch(SQLException e) {
                    // connection close failed.
                    System.err.println(e);
                }
            }
        }
        return flight;
    }
	
    private ArrayList dbGetFlights(String SQL) {
        Connection connection = null;
        ArrayList<ArrayList<String>> flightList = new ArrayList<>();
        ArrayList<String> flights = new ArrayList<>();        
        
        if (!SQL.equals("")) {
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:" +
                    SystemController.dbPath);
                Statement statement = connection.createStatement();
                statement.setQueryTimeout(30);  
                ResultSet rs = statement.executeQuery(SQL);
                
                int count = 0;
                
                while(rs.next()) {
                    flights.add(Integer.toString(rs.getInt("flight_id")));
                    flights.add(rs.getString("origin"));
                    flights.add(rs.getString("destination"));
                    flights.add(rs.getString("departure_date"));
                    flights.add(rs.getString("departure_time"));
                    flights.add(rs.getString("travel_time"));
                    flights.add(Integer.toString(rs.getInt("price")));
                    flights.add(Integer.toString(rs.getInt("nr_of_seats")));

                    flightList.add(flights);
                    count++;
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
        
        return flightList;
    }
	
    public boolean bookFlight(int id, int nrOfPassengers) {
        Integer[] flight = this.dbGet("SELECT * FROM flights WHERE flight_id = " + id);
        int nrOfSeats = flight[1] - nrOfPassengers;

        return this.dbInsert(
            "UPDATE FLIGHTS SET nr_of_seats = " +
            nrOfSeats + " WHERE flight_id = " + flight[0]
        );
    }
	
    public ArrayList getFlights(String origin, String destination, String date) {
        ArrayList flights = this.dbGetFlights(
            "SELECT * FROM flights WHERE origin = '" +
            origin + "' AND destination = '" + destination +
            "' AND departure_date = '" + date + "'" 
        );
        
        return flights;
    }

    // make sure to test!
    public ArrayList getFlightsInfo(int id){
        List flights = this.dbGetFlights(
            "SELECT * FROM flights WHERE flight_id = " + id
        );
        
        //System.out.println(flights[0][1]);
        
        //return flights[0];
        return new ArrayList<>();
    }

    public boolean addFlight(String origin, String destination,
        String deptDate, String deptTime, String travelTime, int price, int seats) {
        return this.addToDatabase(
            origin, destination,deptDate, deptTime, travelTime, price, seats
        );

    }

    public boolean removeFlight(int id){
        return this.deleteFromDatabase(id);
    }

    public boolean updateFlight(int id,String origin, String destination,
        String deptDate, String deptTime, String travelTime, int price, int seats) {
        return this.updateDatabase(
            id,origin, destination,deptDate, deptTime, travelTime, price, seats
        );
    }

    private boolean addToDatabase(String origin, String destination,
        String deptDate, String deptTime, String travelTime, int price, int seats) {
        return this.dbInsert(
            "INSERT INTO flights VALUES('" +
            origin + "', '" +
            destination + "', '" +
            deptDate + "', '" +
            deptTime + "', '" +
            travelTime + "', " +
            price +", " +
            seats + ")"
        );
    }
	
    private boolean deleteFromDatabase(int id){
        return this.dbDelete("DELETE FROM flights WHERE flight_id = "+ id);
    }

    private boolean updateDatabase(int id, String origin, String destination,
            String deptDate, String deptTime, String travelTime, int price,int seats){
        return this.dbInsert(
            "UPDATE flights SET " +
            "origin = '" + origin + 
            "', destination = '" + destination + 
            "', departure_date = '" + deptDate +
            "', departure_time = '" + deptTime +
            "', travel_time = '" + travelTime +
            "', price = " + price +
            ",  nr_of_seats = " + seats + 
            " WHERE flight_id = " + id
        );
    }
}

