package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.model.Student;

@Service
public interface StudentService {

	Student findById(Long id);
	void saveStudent(Student student);
	void updateStudent(Student student);
	void deleteStudentById(Long id);
	List<Student> listAllStudents();

}
