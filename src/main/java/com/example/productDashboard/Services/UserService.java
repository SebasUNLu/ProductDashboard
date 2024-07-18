package com.example.productDashboard.Services;

import com.example.productDashboard.Entities.User;
import com.example.productDashboard.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUser(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User createUser(User user) {
        User newUser = repository.save(user);
        return newUser;
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public User updateUser(User updateUser) {
        User user = repository.save(updateUser);
        return user;
    }

    public UserDTO login(String email, String password) {
        User loggedUser = repository.findByEmailAndPassword(email, password);
        UserDTO userDTO = new UserDTO(loggedUser.getId(), loggedUser.getName(), loggedUser.getEmail());
        return userDTO;
    }


}
