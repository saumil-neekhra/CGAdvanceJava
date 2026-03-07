package in.cg.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cg.main.dto.FoodItemDto;
import in.cg.main.entity.FoodItem;
import in.cg.main.repository.FoodItemRepository;
import jakarta.validation.Valid;

@Service
public class FoodItemServiceImpl implements FoodItemService{
	
	@Autowired
	private FoodItemRepository fr;
	@Override
	public FoodItemDto addFoodItem(@Valid FoodItemDto dto, Long restaurantId) {
		FoodItem f = new FoodItem();
		f.setCategory(dto.getCategory());
		f.setName(dto.getName());
		f.setPrice(dto.getPrice());
		f.setRestaurantId(restaurantId);

		FoodItem saved = fr.save(f);

		dto.setId(saved.getId());
		dto.setRestaurantId(saved.getRestaurantId());

		return dto;
	}

	@Override
	public List<FoodItem> getFoodItemsByRestaurant(Long restaurantId) {
		return fr.findByRestaurantId(restaurantId);
    }

}
