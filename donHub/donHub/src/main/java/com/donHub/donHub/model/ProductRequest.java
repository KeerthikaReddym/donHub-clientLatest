package com.donHub.donHub.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	    private String video;
	    private Condition condition;
	    private LocalDateTime date;
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private ObjectId _id;
	    @Field("Id")
	    private Long customId;

	 // Method to set the current date
	    public void setCurrentDate() {
	        this.date = LocalDateTime.now();
	    }
	   }
