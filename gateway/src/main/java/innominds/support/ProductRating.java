package innominds.support;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductRating {

	@Id
	@GeneratedValue
	private Long id;

	private String productName;
	
	private Long productId;
	
	private Integer productRating;

	private String ratingDescription;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductRating() {
		return productRating;
	}

	public void setProductRating(Integer productRating) {
		this.productRating = productRating;
	}

	public String getRatingDescription() {
		return ratingDescription;
	}

	public void setRatingDescription(String ratingDescription) {
		this.ratingDescription = ratingDescription;
	}

	public ProductRating(){
		
	}
	public ProductRating(Long id, String productName, Integer productRating, String ratingDescription) {
		super();
		this.id = id;
		this.productName = productName;
		this.productRating = productRating;
		this.ratingDescription = ratingDescription;
	}
	
	
	
}
	