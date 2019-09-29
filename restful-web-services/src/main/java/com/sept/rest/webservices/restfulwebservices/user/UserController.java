package com.sept.rest.webservices.restfulwebservices.user;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
@CrossOrigin(origins="http://localhost:4200")
//
public class UserController {
	
	@Autowired
	  private UserRepository userRepository;

	  @GetMapping("/users")
	  public List<User> getAllUsers() 
	  {
	    return userRepository.findAll();
	   
	  }
	  
	  @Bean
	  public PasswordEncoder passwordEncoder() {
	      return new BCryptPasswordEncoder();
	  }

	  
	  @GetMapping("/users/{ID}")
	  public ResponseEntity<User> getUsersByID(@PathVariable(value = "id") Long userID)
	      throws Exception {
	    
		  User user = userRepository.findByUserID(userID).orElseThrow(() -> new Exception("User not found on : " + userID));
		  return  new ResponseEntity<User>(user, HttpStatus.OK);
	  }

	  @PostMapping("/users")
	  public User createUser(@Valid @RequestBody User user) {
		 
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

	@PutMapping("/users/{ID}")
	  public ResponseEntity<User> updateUser(@PathVariable(value = "ID") Long userID, @Valid @RequestBody User userDetails)
	      throws Exception {
		
	    User user = userRepository.findByUserID(userID).orElseThrow(() -> new Exception("User not found on : " + userID));
	    userRepository.delete(user);
	    user.setFirstName(userDetails.getFirstName());
	    user.setLastName(userDetails.getLastName());
	    user.setEmail(userDetails.getEmail());
	    userRepository.save(user);
	    return  new ResponseEntity<User>(user, HttpStatus.OK);
	  
	  }

	  @DeleteMapping("/user/{ID}")
	  public Map<String, Boolean> deleteUser(@PathVariable(value = "ID") Long userID) throws Exception {
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