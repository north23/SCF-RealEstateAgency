package login;

import app.Customers;
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

    public void saveUser(User user) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fake-people-db.txt")));

        if (user != null) {
            pw.println(user.toString());
        }

        pw.close();
    }

    public User loadUser(String userType, String username) throws IOException, CorruptedFileException {
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

            user = createUser(line, userType);
        }
        if (br.readLine() == null)
            throw new CorruptedFileException("The file is empty. No Booking data was loaded.");
        br.close();
        return user;
    }

    private User createUser(String line, String userType) {
        StringTokenizer inReader = new StringTokenizer(line, ",");

        String username = inReader.nextToken();
        String password = inReader.nextToken();
        String uniqueId = inReader.nextToken();

        if (userType.equals("customer")) {
            return new Customer();
        } else {
            return null;
        }
    }
}