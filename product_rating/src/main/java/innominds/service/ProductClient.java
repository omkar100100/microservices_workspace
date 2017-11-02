package innominds.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("product-service")
//@RibbonClient(name="product-service")
public interface ProductClient {
	
	@RequestMapping(value="/products/{productId}",method=RequestMethod.GET)
	public Product getProduct(@PathVariable("productId") Long productId);
	
}
