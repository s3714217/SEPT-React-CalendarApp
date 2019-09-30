package com.sept.rest.webservices.restfulwebservices.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
    @Id
    @GeneratedValue
    private int userID;
    
    @Column(nullable = false)
    private String userName;
	
    @Column(nullable = false)
    private String userPassword;
	
    private String userFirstName;
    private String userLastName;
    private String email;

    public User(int userID, String userName, String userPassword) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        
        
    }

    public int getUserID() {
        return this.userID;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }
    

    public void setUserName(String userName) {
        this.userName = userName;
    }

	public String getFirstName() {
		return userFirstName;
	}

	public void setFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getLastName() {
		return userLastName;
	}

	public void setLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}