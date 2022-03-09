package com.example.bookingproject.repository.user;




import com.example.bookingproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

   Optional<User> getUserByUsername(String username);
}
