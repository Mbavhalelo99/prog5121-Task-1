import java.util.Scanner;
import java.util.ArrayList;

class User {
    String username;
    String password;
    String firstName;
    String lastName;
}

public class RegistrationAndLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<User>();
        
        // Registration
        System.out.println("=== Registration ===");
        User newUser = new User();
        boolean uniqueUsername = false;
        while (!uniqueUsername) {
            System.out.print("Enter a username: ");
            String enteredUsername = scanner.nextLine();
            boolean usernameExists = false;
            for (User user : users) {
                if (user.username.equals(enteredUsername)) {
                    usernameExists = true;
                    break;
                }
            }
            if (usernameExists) {
                System.out.println("Username already exists. Please choose a different username.");
            } else {
                newUser.username = enteredUsername;
                uniqueUsername = true;
            }
        }
        
        boolean validPassword = false;
        while (!validPassword) {
            System.out.print("Enter a password: ");
            String enteredPassword = scanner.nextLine();
            // Implement password security requirements
            if (enteredPassword.length() >= 8) {
                newUser.password = enteredPassword;
                validPassword = true;
            } else {
                System.out.println("Password must be at least 8 characters long.");
            }
        }
        
        System.out.print("Enter your first name: ");
        newUser.firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        newUser.lastName = scanner.nextLine();
        
        users.add(newUser);
        System.out.println("Registration successful.");
        
        // Login
        System.out.println("\n=== Login ===");
        System.out.print("Enter your username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter your password: ");
        String enteredPassword = scanner.nextLine();
        boolean loginSuccessful = false;
        for (User user : users) {
            if (user.username.equals(enteredUsername) && user.password.equals(enteredPassword)) {
                System.out.println("Welcome, " + user.firstName + " " + user.lastName + "!");
                loginSuccessful = true;
                break;
            }
        }
        if (!loginSuccessful) {
            System.out.println("Invalid username or password.");
        }
    }
}

