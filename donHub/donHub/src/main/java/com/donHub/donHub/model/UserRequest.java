package com.donHub.donHub.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "User")
public class UserRequest {
	 @Id
	  private ObjectId _id;
	 @Field("Id")
	    private Long customId;

	
    private String name;
    private String emailId;
    private String password;
    private String phoneNo;
    private Boolean isAdmin;
    private List<String> product;
    private String profilePic;
    
    public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	// Default Constructor
    public UserRequest() {
 
    }
    
    public Long getCustomId() {
		return customId;
	}

	public void setCustomId(Long customId) {
		this.customId = customId;
	}

	// Parameterized Constructor
    public UserRequest(String name, String emailId, String password, String phoneNo, Boolean isAdmin,
                       List<String> product, String profilePic) {
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.phoneNo = phoneNo;
        this.isAdmin = isAdmin;
        this.product = product;
        this.profilePic = profilePic;
    }
    

    // Getters
    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public List<String> getProduct() {
        return product;
    }

    public String getProfilePic() {
        return profilePic;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setProduct(List<String> product) {
        this.product = product;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
   
}