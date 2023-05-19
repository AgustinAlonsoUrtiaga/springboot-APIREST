package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.entity.User;

public interface UserService {
	User createUser(User user);
	List<User> getAllUsers();
}
