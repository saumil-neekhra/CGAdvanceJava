package in.cg.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cg.main.dto.UserDto;
import in.cg.main.entity.User;
import in.cg.main.repository.UserRepository;
import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository ur;
	
	@Override
	public UserDto createUser(@Valid UserDto dto) {
		User u = new User();
		u.setName(dto.getName());
		u.setRole(dto.getRole());
		u.setPassword(dto.getPassword());
		u.setEmail(dto.getEmail());

		User saved = ur.save(u);

		dto.setId(saved.getId());

		return dto;	}
	
}
