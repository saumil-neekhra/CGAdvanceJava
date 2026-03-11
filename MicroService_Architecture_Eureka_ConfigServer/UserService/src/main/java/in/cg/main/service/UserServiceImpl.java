package in.cg.main.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cg.main.dto.UserDTO;
import in.cg.main.entity.User;
import in.cg.main.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(UserDTO userDTO) {

        User user = new User();
        user.setName(userDTO.getName());
        user.setCity(userDTO.getCity());
        user.setEmail(userDTO.getEmail());

        return userRepository.save(user);
    }

    @Override
    public List<User> addAllUsers(List<UserDTO> users) {

        List<User> userList = users.stream().map(dto -> {
            User user = new User();
            user.setName(dto.getName());
            user.setCity(dto.getCity());
            user.setEmail(dto.getEmail());
            return user;
        }).collect(Collectors.toList());

        return userRepository.saveAll(userList);
    }

    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, UserDTO userDTO) {

        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user.setName(userDTO.getName());
            user.setCity(userDTO.getCity());
            user.setEmail(userDTO.getEmail());
            return userRepository.save(user);
        }

        return null;
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }
}