package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.DTO.UserDTO;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

	private UserService userService;
	
	@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
	
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
		UserDTO savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<UserDTO>> getUser(){
		List<UserDTO> savedUsers = userService.getAllUsers();
		return new ResponseEntity<>(savedUsers,HttpStatus.OK);
	}
	
	@GetMapping("{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId){
		UserDTO user = userService.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PutMapping("{userId}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user, @PathVariable Long userId){
		user.setId(userId);
		UserDTO updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") Long idUser){
		userService.deleteUser(idUser);
		return new ResponseEntity<>("Registro borrado con exito!",HttpStatus.OK);
	}
}
