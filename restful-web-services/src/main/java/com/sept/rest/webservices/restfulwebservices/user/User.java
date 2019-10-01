package com.sept.rest.webservices.restfulwebservices.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
    @Id
    @Column(nullable = false)
    private String userName;
	
    @Column(nullable = false)
    private String userPassword;
    
    private String emailAdd;
    private String favColour;
    private String fatherMiddle;
    private String motherMiddle;
	

    public User(String userName, String userPassword) {
    	
        this.userName = userName;
        this.userPassword = userPassword;
      

    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }
    
    public String getEmailAdd() {
        return this.emailAdd;
    }

    
    public String getFavColour() {
        return this.favColour;
    }

    
    public String getFatherMiddle() {
        return this.fatherMiddle;
    }

    
    public String getMotherMiddle() {
        return this.motherMiddle;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }
    
    public void setFavColour(String favColour) {
        this.favColour = favColour;
    }
    
    public void setFatherMiddle(String fatherMiddle) {
        this.fatherMiddle = fatherMiddle;
    }
    
    public void setMotherMiddle(String motherMiddle) {
        this.motherMiddle = motherMiddle;
    }

}

