package login;

import java.util.Scanner;

import app.Customer;
import app.Customer;
import exceptions.CorruptedFileException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu {

    private static final String String = null;
    private Scanner console = new Scanner(System.in);
    //	Map<String, User> user_map = Database.load();
    Scanner keyboard = new Scanner(System.in);

    private Database database = new Database();

    public void run() throws IOException {
        final int MENU_LENGTH = 1;
        String input = "";
        System.out.println("Welcome to S&E Real Estate Agency, \npress any keys to continue: ");
        input = keyboard.nextLine().toUpperCase();
        
        printFirstLoginPage();
        do {
            input = console.nextLine().toUpperCase();
            if (input.length() != MENU_LENGTH) {
                System.out.println("Error - selection must be one Interger/Characters");
            } else {
                switch (input) {
                    case "1":
                        printEmployeeLoginPage();
                        break;
                    case "2":
                        printCustomerLoginPage();
                        break;
                    case "X":
                        onExit();
                }
            }

        } while (!input.equals("X"));

    }

    private void printFirstLoginPage() {
    	System.out.println("Please choose 1 or 2: ");
        System.out.printf("1.Employee\n");
        System.out.printf("2.Customer\n ");
    }

    private void printEmployeeLoginPage() throws IOException {
    	System.out.println("\nAre you a new employee or an existing employee? \nPlease choose 1 or 2: ");
        System.out.printf("1.Register\n");
        System.out.printf("2.Existing User\n");

        String input = "";
        input = console.nextLine().toUpperCase();
        switch (input) {
            case "1":
                registerEmployee();
                break;
            case "2":
                loginEmployee();
                break;
        }
    }

    private void printCustomerLoginPage() throws IOException {
    	System.out.println("\nAre you a new customer or an existing customer? \nPlease choose 1 or 2: ");
        System.out.printf("1.Register\n");
        System.out.printf("2.Existing User\n");

        String input = "";
        input = console.nextLine().toUpperCase();
        switch (input) {
            case "1":
                registerCustomer();
                break;
            case "2":
                loginCustomer();
                break;
        }
    }

    private void onExit() {

    }

    private void registerEmployee() throws IOException {

//       String first_name = "north", last_name = "dec", email = "sdsdwed@hotmail.com", suburb = "vic", username = "north123", password = "pass123";
//		customer.register();

		Scanner keyboard = new Scanner(System.in);	
		System.out.println("\nAll characters entered must be more than 3 characters, \ntype any keys to continue.");
		String input = keyboard.nextLine();
		System.out.println("FirstName :" + "\t");				
		String first_name = keyboard.nextLine();
		
		System.out.println("LastName :" + "\t");	
		String last_name = keyboard.nextLine();
		
		System.out.println("Email :" + "\t");	
		String email = keyboard.nextLine();
		
		System.out.println("Suburb :" + "\t");	
		String suburb = keyboard.nextLine();
		
		System.out.println("Username :" + "\t");	
		String username = keyboard.nextLine();
		
		System.out.println("Password :" + "\t");	
		String password = keyboard.nextLine();


        String[] information = {first_name, last_name, email, suburb, username, password};
        User u = new User(information);

        try {
            database.saveEmpUser(u);
            System.out.println("Registration complete.");
        } catch (IOException ex) {
            System.out.println("Unable to save data...");
        }
    }

    private void loginEmployee() {
        String username, password;
        System.out.println("Username:");
        username = console.nextLine();
        System.out.println("Password:");
        password = console.nextLine();

        try {
            database.loadUser("employee", username, password);
            System.out.println("Login complete.");
        } catch (IOException ex) {
            System.out.println("Unable to load data from file...");
        }
    }

    public void registerCustomer() throws IOException {
//        String firstName = "north", lastName = "dec", email = "sdsdwed@hotmail.com", suburb = "vic", username = "north123", password = "pass123";
//        String type = "vendor";

        Database database = new Database();
        
		System.out.println("\nAll characters entered must be more than 3 characters, \ntype any keys to continue.");
		String input = keyboard.nextLine();
		System.out.println("Please enter your first name: ");
		String firstName = keyboard.nextLine().toUpperCase();

		System.out.println("Please enter your last name: ");
		String lastName = keyboard.nextLine().toUpperCase();

		System.out.println("Please specify if you are a vendor, landlord, buyer or tenant: ");
		String type = keyboard.nextLine().toUpperCase();

		System.out.println("Email :" + "\t");
		String email = keyboard.nextLine();

		System.out.println("Suburb :" + "\t");
		String suburb = keyboard.nextLine();

		System.out.println("Username :" + "\t");
		String username = keyboard.nextLine();

		System.out.println("Password :" + "\t");
		String password = keyboard.nextLine();

//		if (type.equals("vendor")) {
//
//		} else if (type.equals("landlord")) {
//
//		} else if (type.equals("buyer")) {
//
//		} else if (type.equals("tenant")) {
//
//		}
        String[] parts = {firstName, lastName, email, suburb, username, password};
        User user = new Customer(parts, type);

        try {
            database.saveCusUser(user);
            System.out.println("Registration complete.");
        } catch (IOException ex) {
            System.out.println("Unable to save data...");
        }
    }

    private void loginCustomer() {
        String username, password;
        System.out.println("Username:");
        username = console.nextLine();
        System.out.println("Password:");
        password = console.nextLine();

        try {
            database.loadUser("customer", username, password);
            System.out.println("Login complete.");
        } catch (IOException ex) {
            System.out.println("Unable to load data from file...");
        }
    }
}
