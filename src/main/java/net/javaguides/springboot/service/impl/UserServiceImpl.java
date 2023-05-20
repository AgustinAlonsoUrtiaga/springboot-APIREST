package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.DTO.UserDTO;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.mapper.AutoUserMapper;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
    
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDTO createUser(UserDTO userdto) {
		
//		User user = UserMapper.MapToUser(userdto);
		
		//User user = modelMapper.map(userdto, User.class);
		
		User user = AutoUserMapper.MAPPER.mapToUser(userdto);
		
		User savedUser = userRepository.save(user);
		
		
		// UserDTO savedUserDto = modelMapper.map(savedUser, UserDTO.class);
		
		UserDTO savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
		return savedUserDto;
	}
	
	@Override
	public List<UserDTO> getAllUsers(){
		List<User> users = userRepository.findAll();
		//return users.stream().map(UserMapper::maptoUserDto).collect(Collectors.toList());
		//return users.stream().map((user) -> modelMapper.map(users, UserDTO.class)).collect(Collectors.toList());
		return users.stream().map((user) ->	AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
	}

	@Override
	public UserDTO getUserById(Long idUser) {
		Optional<User> optionalUser = userRepository.findById(idUser);
		//return UserMapper.maptoUserDto(user);
		//return modelMapper.map(user, UserDTO.class);
		return AutoUserMapper.MAPPER.mapToUserDto(optionalUser.get());
	}

	@Override
	public UserDTO updateUser(UserDTO user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepository.save(existingUser);
		//return UserMapper.maptoUserDto(updatedUser);
		//return modelMapper.map(updatedUser, UserDTO.class);
		return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
	}

	@Override
	public void deleteUser(Long idUser) {
		userRepository.deleteById(idUser);
	}
	
}
