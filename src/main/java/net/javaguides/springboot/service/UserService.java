package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.DTO.UserDTO;
import net.javaguides.springboot.entity.User;

public interface UserService {
	UserDTO createUser(UserDTO user);
	List<UserDTO> getAllUsers();
	UserDTO getUserById(Long idUser);
	UserDTO updateUser(UserDTO user);
	void deleteUser(Long idUser);
}
