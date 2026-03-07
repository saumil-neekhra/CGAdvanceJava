package in.cg.main.service;

import java.util.List;

import in.cg.main.dto.FoodItemDto;
import in.cg.main.entity.FoodItem;
import jakarta.validation.Valid;

public interface FoodItemService {

	FoodItemDto addFoodItem(@Valid FoodItemDto dto, Long restaurantId);

	List<FoodItem> getFoodItemsByRestaurant(Long restaurantId);

}
