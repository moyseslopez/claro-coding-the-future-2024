package me.dio.domain.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.domain.model.UserModel;
import me.dio.domain.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserModel> findById(@PathVariable("id") Long id) {
		UserModel user = this.userService.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<UserModel> findById(@RequestBody UserModel userToCreate) {
		UserModel userCreated = this.userService.create(userToCreate);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(userCreated.getId())
				.toUri();
		return ResponseEntity.created(uri).body(userCreated);
	}
}
