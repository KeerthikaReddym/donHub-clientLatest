package com.donHub.donHub.model;


import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user", schema = "public")
public class User {
	
	private String name;
	private String emailId;
	private String password;
	private String phoneNo;
	private String address;
	private String profilePic;
	


//isadmin, broughtitems, solditems are updated in the backend
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long playerId;
	private boolean isAdmin = false;
	private int broughtItems = 0;
	private int soldItems = 0;
}
