package innominds.service;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRatingRepository extends JpaRepository<ProductRating,Long> {
	public Collection<ProductRating> findByProductId(Long productId);
}
