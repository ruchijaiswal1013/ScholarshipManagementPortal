package com.davv.scholarship.davv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davv.scholarship.davv.entity.User;
import com.davv.scholarship.davv.repository.UserRepository;

@Service
public class UserService1 {

	@Autowired
	private UserRepository userRepository;

	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	public Iterable<User> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	
}
