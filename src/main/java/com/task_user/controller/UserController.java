package com.task_user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task_user.dao.UserDAO;
import com.task_user.model.User;

@RestController
@RequestMapping("/taskuser")
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	/* to save a user*/
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User us) {
		return userDAO.save(us);
	}
	
	/*get all users*/
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userDAO.findAll();
	}
	
	/*get employee by userid*/
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value="id") Long userid){
		
		User us=userDAO.findOne(userid);
		
		if(us==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(us);
		
	}
	
	
	/*update a user by userid*/
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value="id") Long userid,@Valid @RequestBody User userDetails){
		
		User us=userDAO.findOne(userid);
		if(us==null) {
			return ResponseEntity.notFound().build();
		}
		
		us.setUsername(userDetails.getUsername());
		us.setFirstname(userDetails.getFirstname());
		us.setLastname(userDetails.getLastname());
		
		User updateUser=userDAO.save(us);
		return ResponseEntity.ok().body(updateUser);
		
		
		
	}
	
	/*Delete a user*/
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value="id") Long userid){
		
		User us=userDAO.findOne(userid);
		if(us==null) {
			return ResponseEntity.notFound().build();
		}
		userDAO.delete(us);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}
