package com.donHub.donHub.model;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
	public class ProductRequest {
	    private String name;
	    private String description;
	    private String sellerName;
	    private double price;
	    private String category;
	    private List<String> image;
	    private String video;
	    private String condition;
	    private Date date;

	    // Constructors (you can generate these based on your needs)

	    // Default constructor
	    public ProductRequest() {
	    }

	    // Parameterized constructor
	    public ProductRequest(String name, String description, String sellerName, double price,
	                  String category, List<String> image, String video, String condition, Date date) {
	        this.name = name;
	        this.description = description;
	        this.sellerName = sellerName;
	        this.price = price;
	        this.category = category;
	        this.image = image;
	        this.video = video;
	        this.condition = condition;
	        this.date = date;
	    }

	    // Getters and Setters (you can generate these based on your needs)

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getSellerName() {
	        return sellerName;
	    }

	    public void setSellerName(String sellerName) {
	        this.sellerName = sellerName;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public List<String> getImage() {
	        return image;
	    }

	    public void setImage(List<String> image) {
	        this.image = image;
	    }

	    public String getVideo() {
	        return video;
	    }

	    public void setVideo(String video) {
	        this.video = video;
	    }

	    public String getCondition() {
	        return condition;
	    }

	    public void setCondition(String condition) {
	        this.condition = condition;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }
}
