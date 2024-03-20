package com.crud.library.mapper;

import com.crud.library.domain.User;
import com.crud.library.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getCreatedAccount());
    }

    public UserDto mapToUserDto (final User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getCreatedAccount());
    }

    public List<UserDto> mapToUserDtoList (final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .toList();
    }
}
