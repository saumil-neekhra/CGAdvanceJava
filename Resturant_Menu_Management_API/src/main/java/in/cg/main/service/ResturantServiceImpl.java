package in.cg.main.service;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import in.cg.main.ResturantMenuManagementApiApplication;
import in.cg.main.dto.RestaurantDto;
import in.cg.main.dto.UserDto;
import in.cg.main.entity.Restaurant;
import in.cg.main.repository.ResturantRepository;
import jakarta.validation.Valid;

@Service
public class ResturantServiceImpl implements ResturantService{

	@Autowired
	private ResturantRepository rr;
	@Override
	public  Page<RestaurantDto> getAllRestaurants(int page, int size, String sortBy, String direction) {
		// Create sort Object
				Sort sort = direction.equalsIgnoreCase("asc") ?
						Sort.by(sortBy).ascending() :
							Sort.by(sortBy).descending();
				
				// Create Pageable
				Pageable pageable = PageRequest.of(page,  size, sort);
				
				// Fetch paginated data
				Page<Restaurant> restaurantPage = rr.findAll(pageable);
				
				// Convert Entity Page -> DTO Page
				return restaurantPage.map(restaurant-> {
					RestaurantDto dto = new RestaurantDto();
					dto.setLocation(restaurant.getLocation());
					dto.setName(restaurant.getName());
					dto.setRating(restaurant.getRating());
					dto.setId(restaurant.getId());
					return dto;
				});
	}

	@Override
	public RestaurantDto createRestaurant(@Valid RestaurantDto dto) {
		Restaurant r = new Restaurant();
		r.setLocation(dto.getLocation());
		r.setName(dto.getName());
		r.setRating(dto.getRating());
		
		Restaurant saved = rr.save(r);

		dto.setId(saved.getId());
		return dto;
	}
	
	
}
