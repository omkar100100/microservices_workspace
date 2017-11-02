package innominds.support;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import reactor.rx.Stream;
import reactor.rx.Streams;

@Service
public class ProductService {


	
	@Autowired
	private ProductClient productClient;
	
	@Autowired
	private ProductRatingClient productRatingClient;
	
	public Stream<Product> getProduct(Long productId){
		return Streams.create( sub -> this.productClient.getProduct(productId));
	}
	
	public Stream<ProductRating> getProductRatings(Long productId){
		return Streams.create(subscriber -> {
			this.productRatingClient.getProductRatings(productId).forEach( subscriber::onNext);
			subscriber.onComplete();
		});
	}
	
	public Stream<ProductDetailsDTO> getProductDetails(Long productId,Stream<Product> products,Stream<ProductRating> productDetails){
		return Streams.zip(products.buffer(),productDetails.buffer(),tuple -> new ProductDetailsDTO(tuple.getT1(),tuple.getT2()));
	}
	
	
	public Product getProduct1Fallback(Long productId){
		Product product=new Product();
		return product;
	}
	
	@HystrixCommand(fallbackMethod="getProduct1Fallback")
	public Product getProduct1(Long productId){
	//	InstanceStatus instanceStatus = discoveryClient.getInstanceRemoteStatus();
	//	System.out.println("Instance name:" + instanceStatus.name());
		return  this.productClient.getProduct(productId);
	}
	
	
	public Collection<ProductRating> getProductRatingsFallback1(Long productId){
		Collection<ProductRating> list=new ArrayList<ProductRating>();
		ProductRating rating=new ProductRating();
		list.add(rating);
		return list;
	}
	
	@HystrixCommand(fallbackMethod="getProductRatingsFallback1")
	public Collection<ProductRating> getProductRatings1(Long productId){
		return this.productRatingClient.getProductRatings(productId);
	}
	
	

	public ProductDetailsDTO1 getProductDetails1(Long productId,Product product,Collection<ProductRating> ratings){
		return new ProductDetailsDTO1(product,ratings);
	}
}
