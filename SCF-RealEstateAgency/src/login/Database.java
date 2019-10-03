package login;

import app.Customer;
import app.Property;
import exceptions.CorruptedFileException;

import java.io.*;

import java.util.*;


public class Database {
	
	public static Properties properties = new Properties();
//    public static Map<String, User> load() {
//        Map<String, User> user_map = new HashMap<String, User>();
//        try {
//            Scanner data_store = new Scanner(new File("fake-people-db.txt"));
//
//            while (data_store.hasNextLine()) {
//                String[] split_string = data_store.nextLine().split(",");
//                User u = new User(split_string);
//                user_map.put(u.username, u);
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        return user_map;
//    }
	public void saveEmpUser(User user) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("employee.txt")));

        if (user != null) {
            pw.println(user.toString());
        }

        pw.close();
    }

    public void saveCusUser(User user,String type) throws IOException {
        FileWriter fileWriter =new FileWriter(new File("customer.txt"), true);
        String info = user.toString() +","+type+System.getProperty("line.separator");
        fileWriter.write(info);
        fileWriter.flush();
        fileWriter.close();
    }
    
    public void saveProperty(Property property) throws IOException {
        FileWriter fileWriter =new FileWriter(new File("property.txt"), true);
        String info = property.toString() +System.getProperty("line.separator");
        fileWriter.write(info);
        fileWriter.flush();
        fileWriter.close();
    }

    public User loadUser(String userType, String username, String password) throws IOException {
        String fileName;

        if (userType.equals("customer")) {
            fileName = "customer.txt";
        } else {
            fileName = "employee.txt";
        }

        // Create File Reading Objects
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        User user = null;
        while ((line = br.readLine()) != null) {
            user = createUser(line, userType, username, password);
        }

        br.close();
        return user;
    }
    
    public List<Property> loadProperty() throws IOException {
    	List<Property> list = new ArrayList<Property>();
        String fileName = "property.txt";
        // Create File Reading Objects
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        Property property = null;
        while ((line = br.readLine()) != null) {
        	property = createProperty(line);
        	if(property.getCustId().equals(properties.get("loginUserId"))) {
        		list.add(property);
        	}
        	
        }

        br.close();
        return list;
    }

    private User createUser(String line, String userType, String inputUsername, String inputPassword) {
        StringTokenizer inReader = new StringTokenizer(line, ",");

        String firstName = inReader.nextToken();
        String lastName = inReader.nextToken();
        String email = inReader.nextToken();
        String suburb = inReader.nextToken();
        String username = inReader.nextToken();
        String password = inReader.nextToken();
        String uniqueId = inReader.nextToken();
        String type = null;
		try {
			type = inReader.nextToken();
		} catch (Exception e) {
			return null;
		}

        if (username.equals(inputUsername) && password.equals(inputPassword)) {
            if (userType.equals("customer")) {
            	properties.put("loginUserId", uniqueId);
                String[] parts = {firstName, lastName, email, suburb, username, password,uniqueId};
                return new Customer(parts, type);
            } else {
                return null;
            }
        }
        return null;
    }
    private Property createProperty(String line) {
        StringTokenizer inReader = new StringTokenizer(line, ",");

        String propertyId;
		try {
			propertyId = inReader.nextToken();
		
    	String custId = inReader.nextToken();
    	String address = inReader.nextToken();
    	String suburb = inReader.nextToken();
    	String bedrooms = inReader.nextToken();
    	String bathrooms = inReader.nextToken();
    	String car_spaces = inReader.nextToken();
    	String type = inReader.nextToken();
    	return new Property(propertyId, custId, address, suburb, 
    			Integer.parseInt(bedrooms), 
    			Integer.parseInt(bathrooms), 
    			Integer.parseInt(car_spaces),
    			type);
		} catch (Exception e) {
			return null;
		}
    }
}