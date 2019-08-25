package com.task_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task_user.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
