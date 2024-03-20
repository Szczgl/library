package com.crud.library.controller;

import com.crud.library.domain.User;
import com.crud.library.domain.dto.UserDto;
import com.crud.library.mapper.UserMapper;
import com.crud.library.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library/users")
@RequiredArgsConstructor
public class UserController {

    private final UserDbService userDbService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUser() {
        List<User> users = userDbService.getAllUser();
        return ResponseEntity.ok(userMapper.mapToUserDtoList(users));
    }

    @DeleteMapping(value = "{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userDbService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userDbService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userDbService.saveUser(user);
        return ResponseEntity.ok(userMapper.mapToUserDto(savedUser));
    }

}
