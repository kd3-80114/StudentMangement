package com.app.service;

import java.util.List;

import com.app.dto.StudentListResponseDto;
import com.app.dto.SubjectRequestDto;

public interface AdminService {


	List<StudentListResponseDto> getAllStudents();

	List<String> getAllSubjects();

	String addSubject(SubjectRequestDto subjectName);

}
