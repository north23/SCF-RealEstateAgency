package login;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database 
{
    public static Map<String, User> load()
    {
        Map<String, User> user_map = new HashMap<String, User>();
        try 
        {
            Scanner data_store = new Scanner(new File("fake-people-db.txt"));           

            while (data_store.hasNextLine())
            {
                String[] split_string = data_store.nextLine().split(",");
                User u = new User(split_string);
                user_map.put(u.username, u);
            }                   
          
        } 

        catch (FileNotFoundException e) 
        {
            System.out.println(e.getMessage());
        }
        return user_map;
    }
    
    public static Map<String, User> create(){
		return null;
    	
    }
}