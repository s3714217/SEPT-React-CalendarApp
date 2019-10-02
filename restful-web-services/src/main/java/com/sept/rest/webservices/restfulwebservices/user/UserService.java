package com.sept.rest.webservices.restfulwebservices.user;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;

import com.sept.rest.webservices.restfulwebservices.user.User;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

public List<User> getAllUsers()
	  {
	    return userRepository.findAll();

	  }

//	  @Bean
//	  public PasswordEncoder passwordEncoder() {
//	      return new BCryptPasswordEncoder();
//	  }



public User createUser(@Valid @RequestBody User user) {


		  if (userRepository.findByUserName(user.getUserName()).isPresent() == false)
		  {
			  user = new User(user.getUserName(), user.getUserPassword());
			  return userRepository.save(user);
		  }
		  else
		  {
			  return null;
		  }

	  }



public ResponseEntity<User> getUsersByuserName(@PathVariable(value = "username") String userName)
	      throws Exception {

		  User user = userRepository.findByUserName(userName).orElseThrow(() -> new Exception("User not found on : " + userName));
		  return  new ResponseEntity<User>(user, HttpStatus.OK);
	  }


//public ResponseEntity<User> updateUser(@PathVariable(value = "ID") String userName, @Valid @RequestBody User userDetails)
//	      throws Exception {
//
//	    User user = userRepository.findByUserName(userName).orElseThrow(() -> new Exception("User not found on : " + userName));
//	    userRepository.delete(user);
//	    user.setUserName(userDetails.getUserName());
//	    user.setUserPassword(userDetails.getUserPassword());
//	    user.setEmailAdd(userDetails.getEmailAdd());
//		user.setFavColour(userDetails.getFavColour());
//	    user.setFatherMiddle(userDetails.getFatherMiddle());
//	    user.setMotherMiddle(userDetails.getFatherMiddle());
//	    userRepository.save(user);
//	    return  new ResponseEntity<User>(user, HttpStatus.OK);
//
//	  }


//public Map<String, Boolean> deleteUser(@PathVariable(value = "ID") String userName) throws Exception {
//	    User user =
//	        userRepository
//	            .findByUserName(userName)
//	            .orElseThrow(() -> new Exception("User not found on : " + userName));
//	    userRepository.delete(user);
//	    Map<String, Boolean> response = new HashMap<>();
//	    response.put("deleted", Boolean.TRUE);
//	    return response;
//	  }

}
