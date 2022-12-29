package com.org.njproject.smiter.provider.app.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Component
@Entity(name="TASK")
@Table(name="TASK")
@Getter @Setter
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name="task_title")
    String taskTitle;

    @Column(name="task_items")
    String taskItems;

    @Temporal(TemporalType.DATE)
	@Column(name="due_date")
	private Date dueDate;
}
