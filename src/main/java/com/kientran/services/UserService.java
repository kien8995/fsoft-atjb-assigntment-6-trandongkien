package com.kientran.services;

import java.util.List;

import com.kientran.entities.User;
import com.kientran.repositories.UserRepository;
import com.kientran.services.interfaces.Service;

public class UserService implements Service<User, String> {

	private UserRepository userRepository;

	public UserService() {
		userRepository = new UserRepository();
	}

	public boolean isExist(User user) {
		String id = user.getAccount();
		User temp = userRepository.findById(id);
		return temp != null;
	}

	@Override
	public User save(User user) {
		return userRepository.persist(user);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User update(User user) {
		return userRepository.merge(user);
	}
}
