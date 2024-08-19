package me.dio.domain.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.domain.model.UserModel;
import me.dio.domain.repository.UserRepository;
import me.dio.domain.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	public UserServiceImpl (UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserModel findById(Long id) {
		return this.userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public UserModel create(UserModel user) {
		if(user.getId() != null && this.userRepository.existsById(user.getId())) {
			throw new IllegalArgumentException("This User ID already exists.");
		}
		return this.userRepository.save(user);
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}
}
