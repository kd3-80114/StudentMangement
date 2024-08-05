package com.app.service;

import com.app.dto.StudentReqDetailsDTO;
import com.app.dto.UserDetailsDto;

public interface UserService {
//sign up
	String studentRegistration(StudentReqDetailsDTO dto);
	UserDetailsDto getUserDetails(String email);
}
