package com.donHub.donHub.model;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Product")
	public class ProductRequest {
	    private String name;
	    private String description;
	    private String emailId;
	    private double price;
	    private Category category;
	    private List<byte[]> image;
	    private Condition condition;
	    private Date date;
	    
	    @DBRef
	    private UserRequest user;
	    @Id
	    private ObjectId _id;
	    @Field("Id")
	    private Long customId;
		public void setUserRequest(UserRequest userRequest) {
			this.user = userRequest;
			// TODO Auto-generated method stub
			
		}

	   }
