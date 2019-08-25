package com.task_user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.task_user.model.Task;
import com.task_user.model.User;
import com.task_user.repository.TaskRepository;

public class TaskDAO {
	
	@Autowired
	TaskRepository taskRepository;
	
	/*to save a user*/
	
	public Task save(Task task) {
		return taskRepository.save(task);
	}

/* search all tasks for a given user*/
	
	public List<Task> findAll(){
		return taskRepository.findAll();
	}
	
	

	/*get a task by id*/
	public Task findOne(Long taskid) {
		return taskRepository.findOne(taskid);
	}
	
/*delete a user*/
	
	public void delete(Task task) {
		taskRepository.delete(task);
	}
	
	
	
}
