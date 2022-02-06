package csv.model;

public class User {
    private String username;
    private int identifier;
    private String firstName;
    private String lastName;

    public User() {
    }

    public User(String username, int identifier, String firstName, String lastName) {
        this.username = username;
        this.identifier = identifier;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User[ " + username + ", " + identifier + ", " + firstName + ", " + lastName + "]";
    }
}
