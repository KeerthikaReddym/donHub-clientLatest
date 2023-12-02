package com.donHub.donHub.model;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Product")
	public class ProductRequest {
	    private String name;
	    private String description;
	    private String emailId;
	    private double price;
	    private String category;
	    private List<String> image;
	    private String video;
	    private Condition condition;
	    private Date date;
	    @Id
	    private ObjectId _id;
	    @Field("Id")
	    private Long customId;

	    // Constructors (you can generate these based on your needs)

	    public ObjectId get_id() {
			return _id;
		}

		public void set_id(ObjectId _id) {
			this._id = _id;
		}

		// Default constructor
	    public ProductRequest() {
	    }

	    

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		 public Long getCustomId() {
				return customId;
			}

			public void setCustomId(Long customId) {
				this.customId = customId;
			}

		// Parameterized constructor
	    public ProductRequest(String name, String description, String emailId, double price,
	                  String category, List<String> image, String video, Condition condition, Date date) {
	        this.name = name;
	        this.description = description;
	        this.emailId = emailId;
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

	    public Condition getCondition() {
	        return condition;
	    }

	    public void setCondition(Condition condition) {
	        this.condition = condition;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }
}
