package com.example.bookingproject.service.user;




import com.example.bookingproject.entity.User;
import com.example.bookingproject.exception.AlreadyExistUserWithUsernameException;
import com.example.bookingproject.exception.NotUserFoundException;
import com.example.bookingproject.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Getting all users");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        log.info("Getting User with id = {}", id);
        return userRepository.findById(id).orElseThrow(() -> new NotUserFoundException("Not exist user with id = " + id));
    }

    @Override
    public void deleteUserById(Long id) {
        log.info("Deleting user with id = {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public void saveUser(User user) {
       User getUserFromDb = userRepository.getUserByUsername(user.getUsername()).orElse(User.builder().id(user.getId()).username(user.getUsername()).build());
        if (Objects.equals(getUserFromDb.getUsername(), user.getUsername())) {
            throw new AlreadyExistUserWithUsernameException("Already exist user with that username = " + user.getUsername());
        } else {
            userRepository.save(user);
        }

    }
}
