package app;

import java.util.Scanner;

import login.Database;
import login.User;

public class Customer extends User {
    private String type;

    public Customer(String[] parts, String type) {
        // TODO Auto-generated constructor stub
        super(parts);
        this.type = type;
    }

}
