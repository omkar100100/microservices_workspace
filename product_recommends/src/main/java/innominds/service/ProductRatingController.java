package innominds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RequestMapping("/ratings")
@RestController
public class ProductRatingController {

	private final ProductClient productClient;

	@Autowired
	ProductRatingRepository productRatingRepo;

	@Autowired
	public ProductRatingController(final ProductClient productClient) {
		this.productClient = productClient;
	}

	public ProductRating ratingsFallback(@PathVariable("id") Long productId,
			@RequestBody ProductRatingRequest ratingRequest) {
		System.out.println("This is a fallback method");
		return null;
	}

	@HystrixCommand(fallbackMethod = "ratingsFallback")
	@RequestMapping(value = "/products/{id}", method = RequestMethod.POST)
	public ProductRating getProductRatings(@PathVariable("id") Long productId,
			@RequestBody ProductRatingRequest ratingRequest) {
		Product product = productClient.getProduct(productId);
		ProductRating rating = new ProductRating();
		rating.setProductName(product.getName());
		rating.setProductRating(ratingRequest.getRating());
		rating.setRatingDescription(ratingRequest.getComments());
		rating.setProductId(product.getId());
		return productRatingRepo.save(rating);

	}
}
