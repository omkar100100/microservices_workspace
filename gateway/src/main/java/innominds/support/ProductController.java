package innominds.support;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import reactor.rx.Stream;

@RequestMapping("/api/products")
@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
//	@RequestMapping(value="/{id}/details",method=RequestMethod.GET)
//	public DeferredResult<ProductDetailsDTO> getProductDetails(@PathVariable("id") Long productId){
//		DeferredResult<ProductDetailsDTO> result=new DeferredResult();
//		Stream<Product> productStream=productService.getProduct(productId);
//		Stream<ProductRating> rating=productService.getProductRatings(productId);
//		productService.getProductDetails(productId, productStream, rating)
//		.consume(result::setResult);
//		
//		System.out.println(result.getResult());
//		return result;
//	}
	
	@RequestMapping(value="/{id}/details",method=RequestMethod.GET)
	public ProductDetailsDTO1 getProductDetails(@PathVariable("id") Long productId){
		Product productStream=productService.getProduct1(productId);
		Collection<ProductRating> ratings=productService.getProductRatings1(productId);
		return productService.getProductDetails1(productId, productStream, ratings);
	}
	
}
