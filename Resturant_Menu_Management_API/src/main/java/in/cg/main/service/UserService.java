package in.cg.main.service;

import in.cg.main.dto.UserDto;
import jakarta.validation.Valid;

public interface UserService {

	UserDto createUser(@Valid UserDto dto);
	
}
