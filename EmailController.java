public class EmailController {

	private String user;
	
	//TASK: Sends the reciept to the email adress of the current logged in user after a successful booking
	public boolean sendRecipt(){
		
		//Get current users email ( ? = private varaible user in the class)
		//Select email From Users where username = ?
		
		//Save users email in variable (String email)
		//String email = Value from database;
		
		String recipt=this.makeRecipt();
		
		
		bool ret=this.sendEmail(email, recipt);
		
		return ret;
		
		
		
	}
	
	//TASK: Collects the info about the transcation out of data that is collected from the database
	private int getTranscation(){
		
		//Get current user transaction (? = private varaible user in the class)
		//Select transaction From Transactions where username = ? ORDER BY created desc Limit 1; 
		
		//Save data from database in the variable (int transaction)
		//int transaction = Value from database
		
		return transaction;
	}
	//TASK: Creates the reciept out of data from the getTranscation function
	private void makeRecipt(){
		
		int transaction = this.getTranscation();
		
		//Get current user info (? = private varaible user in the class)
		// Select * From Users where username = ?
		
		//Save data from database in the variable(String [] user)
		//String [] user=Value from database
		
		String reciept="Recipt from TravelPlanner</br>"
				+ "User: " + user['username'] + " bought a ticket value of" + transaction;
		
				
		return reciept 
	
	
	}
	
	
}