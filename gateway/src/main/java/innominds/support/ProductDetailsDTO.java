package innominds.support;

import java.util.Collection;

public class ProductDetailsDTO {
	
	public ProductDetailsDTO(Collection<Product> recommendedProducts,
			Collection<ProductRating> ratings) {
		super();
		this.recommendedProducts = recommendedProducts;
		this.ratings = ratings;
	}
	
	
	private Collection<Product> recommendedProducts;
	private Collection<ProductRating> ratings;
	
	public Collection<Product> getRecommendedProducts() {
		return recommendedProducts;
	}
	public void setRecommendedProducts(Collection<Product> recommendedProducts) {
		this.recommendedProducts = recommendedProducts;
	}
	public Collection<ProductRating> getRatings() {
		return ratings;
	}
	public void setRatings(Collection<ProductRating> ratings) {
		this.ratings = ratings;
	}
	
}
