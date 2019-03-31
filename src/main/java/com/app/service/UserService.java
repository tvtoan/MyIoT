package com.app.service;

import com.app.entity.User;

public interface UserService {
	void addUser(User user);

	Iterable<User> findAllUsers();
	
	User findUserById(Long id);
	
	String getPasswordUser(Long id);

	void editPasswordUser(Long id, String newPassword);
	
	void deleteUser(Long id);
}
