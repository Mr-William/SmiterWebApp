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
@Entity(name="GROUPUSER")
@Table(name="GROUPUSER")
@Getter @Setter
public class GroupUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;

    @Column(name="NAME", nullable=false, unique=true)
	private String name;
	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DOB")
	private Date dob;
}
