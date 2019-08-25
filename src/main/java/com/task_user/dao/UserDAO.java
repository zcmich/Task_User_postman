package com.task_user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.task_user.model.User;
import com.task_user.repository.UserRepository;

@Service
public class UserDAO {
	
	@Autowired
	UserRepository userRepository;
	
	/*to save a user*/
	
	public User save(User us) {
		return userRepository.save(us);
	}
	
	
	/* search all users*/
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	
	/*get a user by id*/
	public User findOne(Long userid) {
		return userRepository.findOne(userid);
	}
	
	
	/*delete a user*/
	
	public void delete(User us) {
		userRepository.delete(us);
	}
	

}
