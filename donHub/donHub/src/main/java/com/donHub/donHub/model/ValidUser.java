package com.donHub.donHub.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ValidUsers")
public class ValidUser {
	@Id
	  private ObjectId _id;
	  private String email;
	  private String name;
	public String getEmail() {
		return email;
	}
	public void setEmail_id(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
