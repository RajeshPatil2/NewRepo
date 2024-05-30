package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
