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

import com.task_user.dao.TaskDAO;
import com.task_user.model.Task;
import com.task_user.model.User;

@RestController
@RequestMapping("/api")


public class TaskController {

	@Autowired
	TaskDAO taskDAO;
	
	/* to save a Task*/
	@PostMapping("/user/{user_id}/task")
	public Task createTask(@Valid @RequestBody Task task) {
		return taskDAO.save(task);
	}
	
	/*get all tasks*/
	@GetMapping("/user/{user_id}/task")
	public List<Task> getAllTasks(){
		return taskDAO.findAll();
	}
	
	
	
	/*get info on a task*/
	@GetMapping("/user/{user_id}/task/{task_id}")
	public ResponseEntity<Task> getTaskById(@PathVariable(value="id") Long taskid){
		
		Task task=taskDAO.findOne(taskid);
		
		if(task==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(task);
		
	}
	
	/*update a task by taskid*/
	@PutMapping("/user/{user_id}/task/{task_id}")
	public ResponseEntity<Task> updateTask(@PathVariable(value="id") Long Taskid,@Valid @RequestBody Task taskDetails){
		
		Task task=taskDAO.findOne(Taskid);
		if(task==null) {
			return ResponseEntity.notFound().build();
		}
		
		task.setName(taskDetails.getName());
		task.setDescriptionOfTask(taskDetails.getDescriptionOfTask());
		task.setDateTime(taskDetails.getDateTime());
		
		Task updateTask=taskDAO.save(task);
		return ResponseEntity.ok().body(updateTask);
		
			}
	
	
	/*Delete a Task*/
	@DeleteMapping("/user/{user_id}/task/{task_id}")
	public ResponseEntity<Task> deleteTask(@PathVariable(value="id") Long taskid){
		
		Task task=taskDAO.findOne(taskid);
		if(task==null) {
			return ResponseEntity.notFound().build();
		}
		taskDAO.delete(task);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	
}
