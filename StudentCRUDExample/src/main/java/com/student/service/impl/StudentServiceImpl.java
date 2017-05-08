package com.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.service.StudentRepository;
import com.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public Student findById(Long id){
		return studentRepository.findOne(id);
	}
	
	public void saveStudent(Student student){
		studentRepository.save(student);
	}
	
	public void updateStudent(Student student){
		studentRepository.save(student);
	}
	
	public void deleteStudentById(Long id){
		studentRepository.delete(id);
	}
	
	public List<Student> listAllStudents(){
		return  studentRepository.findAll();
	}
}
