package com.example.bookingproject.controller;



import com.example.bookingproject.dto.UserDTO;
import com.example.bookingproject.entity.User;
import com.example.bookingproject.mapper.UserMapper;
import com.example.bookingproject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllUsersNames()
    {
       List<String> usernames = userService.getAllUsers().stream().map(userMapper::fromUserToUserDTO).map(UserDTO::getUsername).collect(Collectors.toList());
       return new ResponseEntity<>(usernames, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers()
    {
        List<UserDTO> usernames = userService.getAllUsers().stream().map(userMapper::fromUserToUserDTO).collect(Collectors.toList());
        return new ResponseEntity<>(usernames, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id)
    {
        UserDTO userDTO = userMapper.fromUserToUserDTO(userService.getUserById(id));
        return new ResponseEntity<>(userDTO,HttpStatus.FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserDTO userDTO)
    {
      User user = userMapper.fromUserDTOToUser(userDTO);
      userService.saveUser(user);
      return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }
}
