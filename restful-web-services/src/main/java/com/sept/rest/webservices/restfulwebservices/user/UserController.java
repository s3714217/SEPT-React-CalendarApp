package com.sept.rest.webservices.restfulwebservices.User;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	  
	  @GetMapping("/users/{ID}")
	  public ResponseEntity<User> getUsersByID(@PathVariable(value = "id") Long userID)
	      throws ResourceNotFoundException {
	    User user =
	        userRepository
	            .findByID(userID)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found on : " + userID));
	    return ResponseEntity.ok().body(user);
	  }

	  @PostMapping("/users")
	  public User createUser(@Valid @RequestBody User user) {
	    return userRepository.save(user);
	  }

	  @PutMapping("/users/{ID}")
	  public ResponseEntity<User> updateUser(
	      @PathVariable(value = "ID") Long userID, @Valid @RequestBody User userDetails)
	      throws ResourceNotFoundException {
	    User user =
	        userRepository
	            .findByID(userID)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found on : " + userID));
	    user.setFirstName(userDetails.getFirstName());
	    user.setLastName(userDetails.getLastName());
	    user.setEmail(userDetails.getEmail());
	  }

	  @DeleteMapping("/user/{ID}")
	  public Map<String, Boolean> deleteUser(@PathVariable(value = "ID") Long userID) throws Exception {
	    User user =
	        userRepository
	            .findById(userID)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found on : " + userID));
	    userRepository.delete(user);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }
	  
	  
	  
	  
	  
	  

	}