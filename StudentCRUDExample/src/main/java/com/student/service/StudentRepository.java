package com.student.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
