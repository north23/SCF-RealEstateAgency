package login;

import app.Customer;
import exceptions.CorruptedFileException;

import java.io.*;

import java.util.*;


public class Database {
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

    public void saveCusUser(User user) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("customer.txt")));

        if (user != null) {
            pw.println(user.toString());
        }

        pw.close();
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

    private User createUser(String line, String userType, String inputUsername, String inputPassword) {
        StringTokenizer inReader = new StringTokenizer(line, ",");

        String username = inReader.nextToken();
        String password = inReader.nextToken();
        String firstName = inReader.nextToken();
        String lastName = inReader.nextToken();
        String email = inReader.nextToken();
        String suburb = inReader.nextToken();
        String type = inReader.nextToken();

        if (username.equals(inputUsername) && password.equals(inputPassword)) {
            if (userType.equals("customer")) {
                String[] parts = {firstName, lastName, email, suburb, username, password};
                return new Customer(parts, type);
            } else {
                return null;
            }
        }
        return null;
    }
}