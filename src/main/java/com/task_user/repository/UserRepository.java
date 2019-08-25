package com.task_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task_user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
	
