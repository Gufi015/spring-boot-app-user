package com.example.users.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.users.models.User;
import com.example.users.services.UserService;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/users")
//Definicion de mis rescurso
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping
	@Timed("get.users")
	public ResponseEntity<List<User>> getUsers() {

		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);

	}

	@GetMapping(value = "/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {

		return new ResponseEntity<User>(userService.getUserByUsername(username), HttpStatus.OK);

	}

	@PostMapping
	@Timed("create.user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);

	}

	@PutMapping(value = "/{username}")
	public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(user, username), HttpStatus.OK);
	}

	@DeleteMapping("/{}username")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String username) {
		userService.deleteUser(username);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
