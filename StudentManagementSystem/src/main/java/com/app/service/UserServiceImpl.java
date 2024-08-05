package com.app.service;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SignInDao;
import com.app.dao.StudentDao;
import com.app.dto.StudentReqDetailsDTO;
import com.app.dto.UserDetailsDto;
import com.app.entities.RoleType;
import com.app.entities.SignIn;
import com.app.entities.Student;
import com.app.entities.Subject;
import com.app.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private StudentDao studentdao;
	private	Student student;
	 @Autowired
	 private PasswordEncoder encoder;
	 @Autowired
	 private SignInDao signInDao;
	 

	@Override
	public String studentRegistration(StudentReqDetailsDTO dto) {
			Set<Subject> subjectSet=new TreeSet<Subject>();

		 String encodedPassword=encoder.encode(dto.getPassword());
		 student=new Student();
		 student.setFirstName(dto.getFirstName());
		 student.setLastName(dto.getLastName());
		 student.setEmail(dto.getEmail());
		 student.setContactNo(dto.getContactNo());
		 Subject subject;
		 for (String element : dto.getSubjects()) {
			 subject=new Subject();
			 subject.setName(element);
			 subjectSet.add(subject);
		}
		 student.setSubjects(subjectSet);
		 
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
	public UserDetailsDto getUserDetails(String email) {
		UserDetailsDto dto=null;
		SignIn signIn=signInDao.findByEmail(email).orElseThrow(null);	
		if(signIn!=null)
		{
			dto=new UserDetailsDto();
			dto.setEmail(signIn.getEmail());
			dto.setUserRole(signIn.getUserRole().toString());
		}
		return dto;
	}
}