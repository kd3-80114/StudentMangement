package com.app.dto;

import java.util.Set;

import com.app.entities.Subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentReqDetailsDTO {
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String contactNo;
	private Set<String> subjects;
	}