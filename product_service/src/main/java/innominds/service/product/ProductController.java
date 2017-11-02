package innominds.service.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RequestMapping("/products")
@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	public ProductController() {
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Product> getProducts(Long productId) {
		return productRepository.findAll();
	}

	public Product getProductFallback(@PathVariable Long productId) {
		Product product = new Product();
		return product;
	}

	@HystrixCommand(fallbackMethod = "getProductFallback")
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable Long productId) {
		return productRepository.findOne(productId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@RequestMapping(value = "/ids", method = RequestMethod.GET)
	public Collection<Product> getProductsByIds(@RequestParam(value = "ids") String productIds) {
		java.util.List idList = Arrays.asList(productIds.split(","));
		return productRepository.findAll(idList);
	}
}
