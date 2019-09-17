package login;
import java.util.Scanner;

import app.Customers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Menu {
	
	private static final String String = null;
	private Scanner console = new Scanner(System.in);
	Map<String, User> user_map = Database.load();
	
	private Database database = new Database();

	public void run() throws IOException {
		final int MENU_LENGTH = 1;
		String input = "";
		printFirstLoginPage();
		do {						
			input = console.nextLine().toUpperCase();
			if(input.length() != MENU_LENGTH) {
				System.out.println("Error - selection must be one Interger/Characters");
			}else {
				switch(input) {
				case "1":
					printSecondLoginPage();
					break;
				case "2":
					printSecondLoginPage();								 
					break;
				case "X":
					onExit();
				}
			}
			
			
			
		} while (!input.equals("X"));
		
		
		
		
	}
	
	private void printFirstLoginPage(){
		
		System.out.printf("1.Employee\n");
		System.out.printf("2.Customer\n ");
	}
	
	private void printSecondLoginPage() throws IOException {
		
		System.out.printf("1.Register\n");
		System.out.printf("2.Existing User\n");
		
		String input = "";
		input = console.nextLine().toUpperCase();
		 switch(input) {
           case "1":
        	registerUser();
               break;
           case "2":
           	existingUser();	
				break;
		 }
	}
	
	private void onExit() {
		
	}
	
	private void existingUser() {
		
		 Map<String, User> user_map = Database.load();

	        Scanner keyboard = new Scanner(System.in);
	        String username,password;

	        System.out.println("Enter username");
	        username = keyboard.nextLine();

	        if (!user_map.containsKey(username))
	        {
	            System.out.println("That username does not exist.");
	            System.exit(0);
	        }   

	        System.out.println("Enter password");
	        password = keyboard.nextLine();

	        User un = user_map.get(username);

	            if((un.password).equals(password))
	            {
	                System.out.println("Successfully logged in.");
	                System.out.println("Welcome " + un.first_name + " "+ un.last_name);
	            }
	            else
	                System.out.println("Incorrect password");
	    }
	
	private void registerUser() throws IOException {		
		
		String first_name = "north", last_name = "dec" , email = "sdsdwed@hotmail.com", suburb = "vic", username = "north123", password = "pass123";
		
//		Scanner keyboard = new Scanner(System.in);		
//		System.out.println("FirstName :" + "\t");				
//		String first_name = keyboard.nextLine();
//		
//		System.out.println("LastName :" + "\t");	
//		String last_name = keyboard.nextLine();
//		
//		System.out.println("Email :" + "\t");	
//		String email = keyboard.nextLine();
//		
//		System.out.println("Suburb :" + "\t");	
//		String suburb = keyboard.nextLine();
//		
//		System.out.println("Username :" + "\t");	
//		String username = keyboard.nextLine();
//		
//		System.out.println("Password :" + "\t");	
//		String password = keyboard.nextLine();
		
		
		String[] information = {first_name, last_name, email, suburb, username, password};
		User u = new User(information);
		
		database.saveUser(u);
		
		
	}
}
	

