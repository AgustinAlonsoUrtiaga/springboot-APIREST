package net.javaguides.springboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.javaguides.springboot.DTO.UserDTO;
import net.javaguides.springboot.entity.User;

@Mapper
public interface AutoUserMapper {
	
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
	
	UserDTO mapToUserDto(User user);
	
	User mapToUser(UserDTO userDto);
	
}
