package com.task_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.task_user.controller"})
		
public class TaskUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskUserApplication.class, args);
	}

}
