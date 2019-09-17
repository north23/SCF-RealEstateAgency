package app;

import java.util.Scanner;

import login.Database;
import login.User;

public class Customer extends User
{
	//Customers attributes
		
	//Registering attributes
	
	private String type;

	
	
	Scanner sc = new Scanner (System.in);
					
	public Customer(String[] parts, String type) {
		// TODO Auto-generated constructor stub
		super(parts);
		this.type = type;
	}	
	
}
