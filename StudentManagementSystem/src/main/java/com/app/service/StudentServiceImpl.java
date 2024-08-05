package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.SignInDao;
import com.app.dao.StudentDao;
import com.app.dto.StudentReqDetailsDTO;
import com.app.entities.RoleType;
import com.app.entities.SignIn;
import com.app.entities.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentdao;
	private	Student student;
	 @Autowired
	 private PasswordEncoder encoder;
	 
	 public String StudentRegistration(StudentReqDetailsDTO dto)
	 {
		 String encodedPassword=encoder.encode(dto.getPassword());
		 student=new Student();
		 student.setFirstName(dto.getFirstName());
		 student.setLastName(dto.getLastName());
		 student.setEmail(dto.getEmail());
		 student.setContactNo(dto.getContactNo());
		 
		 student.setPassword(encodedPassword);
		 
		 SignIn signIn=new SignIn();
		 signIn.setEmail(dto.getEmail());
		 signIn.setPassword(encodedPassword);
		 signIn.setUserRole(RoleType.ROLE_STUDENT);
		 
		 student.setSignIn(signIn);
		 
		  if(studentdao.save(student)!=null)
		  {
			  return "Student Created Successfully";
		  }
		  return "Student creation failed";
		 
		 
	 }

	@Override
	public String createStudent(StudentReqDetailsDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	 
	
	
	
}
