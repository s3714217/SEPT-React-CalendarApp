package com.sept.rest.webservices.restfulwebservices.user;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

import com.sept.rest.webservices.restfulwebservices.user.user;

@Component
public class UserService {
    @Autowired
    UserRepository repository;
	
public List<User> getAllUsers() 
	  {
	    return userRepository.findAll();
	   
	  }
	  
	  @Bean
	  public PasswordEncoder passwordEncoder() {
	      return new BCryptPasswordEncoder();
	  }
	
	
	
public void createUser(@Valid @RequestBody User user) {
		 
		  if (userRepository.findByUserID(user.getUserID()).isPresent() == false)
		  {
			  user = new User(user.getUserID(), user.getUserName(),this.passwordEncoder().encode(user.getUserPassword()));
			  return userRepository.save(user);
		  }
		  else
		  {
			  return null;
		  }
		  
	  }
	  
	  
	  
public ResponseEntity<User> getUsersByID(@PathVariable(value = "id") int userID)
	      throws Exception {
	    
		  User user = userRepository.findByUserID(userID).orElseThrow(() -> new Exception("User not found on : " + userID));
		  return  new ResponseEntity<User>(user, HttpStatus.OK);
	  }

	  
public ResponseEntity<User> updateUser(@PathVariable(value = "ID") int userID, @Valid @RequestBody User userDetails)
	      throws Exception {
		
	    User user = userRepository.findByUserID(userID).orElseThrow(() -> new Exception("User not found on : " + userID));
	    userRepository.delete(user);
	    user.setFirstName(userDetails.getFirstName());
	    user.setLastName(userDetails.getLastName());
	    user.setEmail(userDetails.getEmail());
		user.setFavColour(userDetails.getFavColour());
	    user.setFatherMiddle(userDetails.getFatherMiddle());
	    user.setMotherMiddle(userDetails.getFatherMiddle());
	    userRepository.save(user);
	    return  new ResponseEntity<User>(user, HttpStatus.OK);
	  
	  }
	  
	  
public Map<String, Boolean> deleteUser(@PathVariable(value = "ID") int userID) throws Exception {
	    User user =
	        userRepository
	            .findById(userID)
	            .orElseThrow(() -> new Exception("User not found on : " + userID));
	    userRepository.delete(user);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }
	  
}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  