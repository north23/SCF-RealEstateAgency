package app;

import java.util.Scanner;

import login.Database;

public class Customers extends User
{
	//Customers attributes
	private String name;
	private String email;
	
	//Registering attributes
	private String firstName;
	private String lastName;
	private String type;
	private String Id;
	private String vendor;
	private String landlord;
	private String buyer;
	private String tenant;
	
	Scanner sc = new Scanner (System.in);
	
	public Customers (String name, String email)
	{
		this.name = name;
		this.email = email;
	}
	
	public boolean register ()
	{
		Database database = new Database();
		
		System.out.println("Please enter your first name: ");
		firstName = sc.nextLine().toUpperCase();
		System.out.println("Please enter your last name: ");
		lastName = sc.nextLine().toUpperCase();
		System.out.println("Please specify if you are a vendor, landlord, buyer or tenant: ");
		type = sc.nextLine().toUpperCase();
		
		if (type.equals(vendor))
		{
			
		}else if (type.equals(landlord))
		{
			
		}else if (type.equals(buyer))
		{
			
		}else if (type.equals(tenant))
		{
			
		} 
		
		
		database.saveUser(this);
		return false;
	}
			
	public void generateId(String firstName, String lastName, String email)
	{
		if(firstName.length() < 2 || lastName.length() < 2 || email.length() < 5)
		{
			Id = "Invalid";
		}
		else
		{
			Id = firstName.substring(0, 3).toUpperCase() + lastName.substring(0, 3).toUpperCase()
				 + email.substring(0, 3).toUpperCase();
		}
	}
	
	
}
