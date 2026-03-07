package in.cg.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.main.dto.RestaurantDto;
import in.cg.main.entity.Restaurant;

public interface ResturantRepository extends JpaRepository<Restaurant, Long>{

}
