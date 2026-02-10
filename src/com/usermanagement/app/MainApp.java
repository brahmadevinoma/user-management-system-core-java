package com.usermanagement.app;

import java.util.Scanner;

import com.usermanagement.exception.InvalidCredentialsException;
import com.usermanagement.exception.UserAlreadyExistsException;
import com.usermanagement.exception.UserNotFoundException;
import com.usermanagement.model.User;
import com.usermanagement.service.UserService;

public class MainApp {

    public static void main(String[] args) {

        UserService userService = new UserService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== USER MANAGEMENT SYSTEM ====");
            System.out.println("1. Register");
            System.out.println("2. Login using User ID");
            System.out.println("3. Login using Username");
            System.out.println("4. Update Password");
            System.out.println("5. Delete User");
            System.out.println("6. Show All Users");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Username: ");
                        String username = sc.nextLine();

                        System.out.print("Enter Password: ");
                        String password = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        User user = new User(id, username, password, email);
                        userService.register(user);

                        System.out.println("User registered successfully");
                        break;

                    case 2:
                        System.out.print("Enter User ID: ");
                        int loginId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Password: ");
                        String passById = sc.nextLine();

                        userService.loginById(loginId, passById);
                        System.out.println("Login successful (by ID)");
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        String loginUsername = sc.nextLine();

                        System.out.print("Enter Password: ");
                        String passByUsername = sc.nextLine();

                        userService.loginByUsername(loginUsername, passByUsername);
                        System.out.println("Login successful (by Username)");
                        break;

                    case 4:
                        System.out.print("Enter Username: ");
                        String updateUser = sc.nextLine();

                        System.out.print("Enter New Password: ");
                        String newPassword = sc.nextLine();

                        userService.updatePasswordByUsername(updateUser, newPassword);
                        System.out.println("Password updated successfully");
                        break;

                    case 5:
                        System.out.print("Enter Username to delete: ");
                        String deleteUser = sc.nextLine();

                        userService.deleteUserByUsername(deleteUser);
                        System.out.println("User deleted successfully");
                        break;

                    case 6:
                        userService.showAllUsers();
                        break;

                    case 7:
                        System.out.println("Exiting application...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (UserAlreadyExistsException |
                     UserNotFoundException |
                     InvalidCredentialsException e) {

                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
