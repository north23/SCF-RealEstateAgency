package login;

public class User {
	
	    public String first_name, last_name, email, suburb, username, password; 

	    public User(String[] parts)
	    {
	        first_name = parts[0];
	        last_name = parts[1];
	        email = parts[2];
	        suburb = parts[3];
	        username = parts[4];
	        password = parts[5];
	    }
	    
	    public boolean doesPasswordEqual(String password) {
	        return this.password.equals(password);
	    }
	
}
