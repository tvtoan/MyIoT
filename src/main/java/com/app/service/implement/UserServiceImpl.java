package com.app.service.implement;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.repository.UserRepository;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public Iterable<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public String getPasswordUser(Long id) {
		return userRepository.findById(id).get().getPassword();
	}

	@Override
	@Transactional
	public void editPasswordUser(Long id, String newPassword) {
		userRepository.changePassword(newPassword, id);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
