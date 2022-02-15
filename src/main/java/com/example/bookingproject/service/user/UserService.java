package com.example.bookingproject.service.user;




import com.example.bookingproject.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUserById(Long id);
    void saveUser(User user);
}
