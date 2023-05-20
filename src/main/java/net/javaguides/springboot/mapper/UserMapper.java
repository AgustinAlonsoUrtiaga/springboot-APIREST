package net.javaguides.springboot.mapper;

import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.DTO.UserDTO;

public class UserMapper {
	
	public static UserDTO maptoUserDto(User user) {
		UserDTO userDto = new UserDTO(
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail()
		);
		
		return userDto;
	}
	
	public static User MapToUser(UserDTO userDto) {
		User user = new User(
				userDto.getId(),
				userDto.getFirstName(),
				userDto.getLastName(),
				userDto.getEmail()
		);
		
		return user;
	}
}
