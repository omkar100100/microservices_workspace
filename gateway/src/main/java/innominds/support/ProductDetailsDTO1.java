package innominds.support;

import java.util.Collection;

public class ProductDetailsDTO1 {
	
	public ProductDetailsDTO1(Product product,
			Collection<ProductRating> ratings) {
		super();
		this.product=product;
		this.ratings = ratings;
	}
	
	
	private Product product;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}


	private Collection<ProductRating> ratings;
	
	
	public Collection<ProductRating> getRatings() {
		return ratings;
	}
	public void setRatings(Collection<ProductRating> ratings) {
		this.ratings = ratings;
	}
	
}
