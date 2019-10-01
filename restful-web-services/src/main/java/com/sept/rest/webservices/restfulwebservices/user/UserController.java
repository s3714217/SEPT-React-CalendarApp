package com.sept.rest.webservices.restfulwebservices.user;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
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
	UserService service;;

	  @GetMapping("/users")
	  public List<User> getAllUsers() 
	  {
	    return service.getAllUsers();
	   
	  }
	  
	  @Bean
	  public PasswordEncoder passwordEncoder() {
	      return new BCryptPasswordEncoder();
	  }

	  
	  @GetMapping("/users/{username}")
	  public ResponseEntity<User> getUsersByID(@PathVariable(value = "username") String userName)
	      throws Exception {
	    
		  return service.getUsersByuserName(userName);
	  }

	  @PostMapping("/users/{user}")
	  public User createUser(@Valid @RequestBody User user) {
		  
		    
		  service.createUser(user);
		  return user;
		  
	  }

//	@PutMapping("/users/{username}")
//	  public ResponseEntity<User> updateUser(@PathVariable(value = "username") String userName, @Valid @RequestBody User userDetails)
//	      throws Exception {
//			User user = userfindByUserName(userName);
//		
//	    return  ResponseEntity<User,>;
//	  
//	  }

//	  @DeleteMapping("/user/{ID}")
//	  public Map<String, Boolean> deleteUser(@PathVariable(value = "ID") String userName) throws Exception {
//	    
//	    service.delete(user);
//
//	  }
	  

	}
