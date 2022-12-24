package com.org.njproject.smiter.provider.app.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Component
@Entity(name="GROUPS")
@Table(name="GROUPS")
@Getter @Setter
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name="id")
    Long id;

    @Column(name="name")
    String name;

    @Column(name="group_email")
    String groupEmail;

    @Column(name="owner_name")
    String ownerName;

    @Column(name="task_count")
    Integer taskListCount;

    @Column(name="member_count")
    Integer memberCount;
}
