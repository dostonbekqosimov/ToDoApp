package doston.uz.ToDoApp.service;

import doston.uz.ToDoApp.User;
import doston.uz.ToDoApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public String addNewUser(User user) {
        userRepository.save(user);
        return "New user joined!";

    }

    public User getUser(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            System.out.println("User with this id not found");
        }
        return user.get();
    }

    public String updateUser(Integer userId, User user) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            System.out.println("User with this id not found");
        }

        User existingUser = userOptional.get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        userRepository.save(existingUser);
        return "User updated successfully";


    }

    public void deleteUser(Integer userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("student with id-" + userId + " doesn't exist");
        }
        userRepository.deleteById(userId);
    }
}
