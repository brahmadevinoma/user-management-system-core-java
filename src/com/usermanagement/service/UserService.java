package com.usermanagement.service;

import java.util.HashMap;
import java.util.Map;

import com.usermanagement.exception.*;
import com.usermanagement.model.User;

public class UserService {

	
	private Map<Integer, User> usersById = new HashMap<Integer,User>();
	private Map<String, User> usersByUsername = new HashMap<String,User>();
	
	// Register
	
	 public void register(User user) throws UserAlreadyExistsException 
	 {
		 if(usersById.containsKey(user.getId()))
		 {
			 throw new UserAlreadyExistsException("User Id Aleady Exist.");
		 }
		 
		 if(usersByUsername.containsKey(user.getUsername()))
		 {
			 throw new UserAlreadyExistsException("User Name Already Exist.");
		 }
		 
		 usersById.put(user.getId(), user);
		 usersByUsername.put(user.getUsername(), user);
	 }
	// 2. Login by ID
	    public void loginById(int id, String password)
	            throws UserNotFoundException, InvalidCredentialsException {

	        User user = usersById.get(id);

	        if (user == null) {
	            throw new UserNotFoundException("User ID not found");
	        }

	        if (!user.getPassword().equals(password)) {
	            throw new InvalidCredentialsException("Invalid password");
	        }
	    }

	    // 3. Login by Username
	    public void loginByUsername(String username, String password)
	            throws UserNotFoundException, InvalidCredentialsException {

	        User user = usersByUsername.get(username);

	        if (user == null) {
	            throw new UserNotFoundException("Username not found");
	        }

	        if (!user.getPassword().equals(password)) {
	            throw new InvalidCredentialsException("Invalid password");
	        }
	    }

	    // 4. Update password
	    public void updatePasswordByUsername(String username, String newPassword)
	            throws UserNotFoundException {

	        User user = usersByUsername.get(username);

	        if (user == null) {
	            throw new UserNotFoundException("User not found");
	        }

	        user.setPassword(newPassword);
	    }

	    // 5. Delete user
	    public void deleteUserByUsername(String username)
	            throws UserNotFoundException {

	        User user = usersByUsername.get(username);

	        if (user == null) {
	            throw new UserNotFoundException("User not found");
	        }

	        usersByUsername.remove(username);
	        usersById.remove(user.getId());
	    }

	    // 6. Show all users
	    public void showAllUsers() {
	        for (User user : usersById.values()) {
	            System.out.println(
	                user.getId() + " | " +
	                user.getUsername() + " | " +
	                user.getEmail()
	            );
	        }
	    }
	}