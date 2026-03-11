package in.cg.main.service;

import java.util.List;

import in.cg.main.dto.UserDTO;
import in.cg.main.entity.User;

public interface UserService {
	
 	User addUser(UserDTO userDTO);

    List<User> addAllUsers(List<UserDTO> users);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);
}
