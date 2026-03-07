package in.cg.main.service;

import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.Page;

import in.cg.main.dto.RestaurantDto;
import jakarta.validation.Valid;

public interface ResturantService {
	
	Page<RestaurantDto> getAllRestaurants(int page, int size, String sortBy, String direction);

	RestaurantDto createRestaurant(@Valid RestaurantDto dto);

}
