package in.cg.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.cg.main.dto.FoodItemDto;
import in.cg.main.dto.RestaurantDto;
import in.cg.main.dto.UserDto;
import in.cg.main.entity.FoodItem;
import in.cg.main.service.FoodItemService;
import in.cg.main.service.ResturantService;
import in.cg.main.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private UserService us;
	@Autowired
	private ResturantService rs;
	@Autowired
	private FoodItemService fs;
	
	@PostMapping("/users/register")
	public UserDto registerUser(@Valid @RequestBody UserDto dto) {
		return us.createUser(dto);
	}
	
	@GetMapping("/restaurants")
	public ResponseEntity<Page<RestaurantDto>> getAllRestaurants(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size,
			@RequestParam(defaultValue = "name") String sortBy,
			@RequestParam(defaultValue = "asc") String direction){
		return ResponseEntity.ok(
				rs.getAllRestaurants(page, size, sortBy, direction)
				);
	}
	
	@PostMapping("/restaurants")
	public RestaurantDto registerRestaurant(@Valid @RequestBody RestaurantDto dto) {
		return rs.createRestaurant(dto);
	}
	
	@PostMapping("/restaurants/{restaurantId}/fooditems")
	public FoodItemDto addFoodItem(@Valid @RequestBody FoodItemDto dto,
			@PathVariable Long restaurantId) {
		return fs.addFoodItem(dto,restaurantId);
	}
	
	@GetMapping("/restaurants/{restaurantId}/fooditems")
    public ResponseEntity<List<FoodItem>> getFoodItemsByRestaurant(
            @PathVariable Long restaurantId) {

        List<FoodItem> items =
                fs.getFoodItemsByRestaurant(restaurantId);

        return ResponseEntity.ok(items);
    }
	
	
}
