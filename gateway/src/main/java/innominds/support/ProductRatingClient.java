package innominds.support;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient("product-rating")
public interface ProductRatingClient {
	@RequestMapping(value = "ratings/products/{id}", method = RequestMethod.GET)
	public Collection<ProductRating> getProductRatings(@PathVariable("id") Long productId);
}
