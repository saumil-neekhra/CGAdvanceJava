package in.cg.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.main.dto.FoodItemDto;
import in.cg.main.entity.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long>{
	List<FoodItem> findByRestaurantId(Long restaurantId);
}
