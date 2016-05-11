package travelplanner;



public class AccountController {	
	private String user;
	private String password;
	
	public AccountController(String user, String password)
	{
		this.user = user;
		this.password = password;
	}
	
	public String login()
	{
		return "tmp";
	}
	
	public boolean register(String firstName, String lastName)
	{
		boolean success = false;
		success = addUserToDB(firstName, lastName);
		
		return success;
	}
	
	private boolean addUserToDB(String firstName, String lastName)
	{
		String user = this.user;
		String password = this.password;
		
		return true;
	}
	
	private String getUser()
	{
		return "tmp";
	}
	
	/**		TODO		**/
	/**ADD fetchUserFromDB Function**/
	
}