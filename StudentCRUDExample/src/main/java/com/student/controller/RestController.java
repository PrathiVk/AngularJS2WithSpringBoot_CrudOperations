package com.student.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.model.Student;
import com.student.service.StudentService;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestController.class);
	@Autowired
	private StudentService studentService;
	
	
	
	@RequestMapping(path="/student/", method= RequestMethod.GET)
	public ResponseEntity<List<Student>> retrieveList()
	{
		List<Student> student = studentService.listAllStudents();
		
		if(student.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
	}
	
	@RequestMapping(path="/student/{id}", method= RequestMethod.GET)
	public ResponseEntity<Object> getStudent(@PathVariable Long id)
	{
		logger.info("retieving Student by ID{}",id);
		Student student = studentService.findById(id);
		if(student == null){
			logger.error("Student with id{} not found",id);
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(student, HttpStatus.OK);
	}
	
	
	@RequestMapping(path="/student/add", method= RequestMethod.POST)
	public ResponseEntity<Object> addStudent(@RequestBody Student student)
	{
		logger.info("Creatind Student ", student);
		studentService.saveStudent(student);
		return new ResponseEntity<Object>(student, HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/student/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Object> updateStudent(@PathVariable("id") Long id, @RequestBody Student student)
	{
		logger.info("Updating student with id{}", id);;
		Student currentStudent = studentService.findById(id);
		
		currentStudent.setID(student.getID());
		currentStudent.setStudentName(student.getStudentName());
		currentStudent.setCity(student.getCity());
		currentStudent.setStreet(student.getStreet());
		currentStudent.setState(student.getState());
		currentStudent.setZipcode(student.getZipcode());
		currentStudent.setCountry(student.getCountry());
		
		studentService.updateStudent(currentStudent);		
		return new ResponseEntity<Object>(student, HttpStatus.OK);
	}	

	@RequestMapping(path="/student/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStudent(@PathVariable("id") Long id)
	{
		logger.info("Deleting student with id{}",id);
		
		studentService.deleteStudentById(id);
		
		return new ResponseEntity<Object>(null, HttpStatus.NO_CONTENT);
	}
}
