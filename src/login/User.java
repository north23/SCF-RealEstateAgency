package login;

public class User {

    public String first_name, last_name, email, suburb, username, password, uniqueId;

    public User(String[] parts) {
        first_name = parts[0];
        last_name = parts[1];
        email = parts[2];
        suburb = parts[3];
        username = parts[4];
        password = parts[5];
        uniqueId = parts[6];
    }

    public boolean doesPasswordEqual(String password) {
        return this.password.equals(password);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(username)
                .append(",")
                .append(password)
                .append(",")
                .append(uniqueId);

        return sb.toString();
    }

    private String genUserID() {
        String id;

        if (first_name.length() < 2 || last_name.length() < 2 || email.length() < 5) {
            id = "Invalid";
        } else {
            id = first_name.substring(0, 3).toUpperCase() + last_name.substring(0, 3).toUpperCase()
                    + email.substring(0, 3).toUpperCase();
        }
        return id;
    }

}
