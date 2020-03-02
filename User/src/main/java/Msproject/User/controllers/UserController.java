package Msproject.User.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Msproject.User.models.User;
import Msproject.User.repositories.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository UserRepository;
	
	@GetMapping(value = "/user/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		return userRepository.findById(id);
	}
	
	@GetMapping(value = "/users")
	public List<User> getUsers() {
		System.out.println("trace getUsers");
		List<User> users = new ArrayList<User>(); 
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	@PostMapping(value="/add")
	public void addUser(@RequestBody User u) {
		System.out.println("trace addUser");
		UserRepository.save(u);
	}
	
	@PutMapping(value = "/update")
	public void updateUser(@RequestBody User u) {
		System.out.println("trace update");
		userRepository.save(u);
	}
	
	@DeleteMapping(value = "/delete")
	public void deleteUser(@RequestBody User u) {
		System.out.println("trace delete");
		userRepository.delete(u);
	}	
	
	@PostMapping(value="/login")
	public boolean login(@RequestBody User u) {
		System.out.println("trace login");
		return userRepository.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
	
	
}
