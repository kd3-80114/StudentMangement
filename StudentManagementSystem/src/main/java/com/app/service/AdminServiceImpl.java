package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDao;
import com.app.dao.SubjectDao;
import com.app.dto.StudentListResponseDto;
import com.app.dto.SubjectRequestDto;
import com.app.entities.Student;
import com.app.entities.Subject;
@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private ModelMapper mapper;
	
	private Subject subject;
	
	
	@Override
	public List<StudentListResponseDto> getAllStudents() {
	List<Student> studentlist=studentDao.findAll();
	List<StudentListResponseDto> studentResponseList=new ArrayList<StudentListResponseDto>();
	for (Student student : studentlist) {
		studentResponseList.add(mapper.map(student, StudentListResponseDto.class));	
	}
	return studentResponseList;
					
	}


	@Override
	public List<String> getAllSubjects() {
		List<Subject> subjectList=subjectDao.findAll();
		List<String> subjectResponseList= new ArrayList<String>();
		for (Subject subject : subjectList) {
			subjectResponseList.add(subject.getName());
		}
		
		return subjectResponseList;
		
	}


	@Override
	public String addSubject(SubjectRequestDto subjectName) {
		subject=new Subject();
		subject.setName(subjectName.getSubjectName());
		
		if(subjectDao.save(subject)!=null)
		{
			return "Subject added successfully";
		}
		return "Adding Subject failed";	
	}

}
