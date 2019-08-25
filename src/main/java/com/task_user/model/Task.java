package com.task_user.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="Task")
@EntityListeners(AuditingEntityListener.class)

public class Task {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String DescriptionOfTask;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date DateTime;
	

	
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.LAZY,targetEntity = Task.class)
	  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false)
	  private List<User> user;

	
	
    public List<User> getUser() {
		return user;
	}


	public void setUser(List<User> user) {
		this.user = user;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescriptionOfTask() {
		return DescriptionOfTask;
	}


	public void setDescriptionOfTask(String descriptionOfTask) {
		DescriptionOfTask = descriptionOfTask;
	}


	public Date getDateTime() {
		return DateTime;
	}


	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}


}
