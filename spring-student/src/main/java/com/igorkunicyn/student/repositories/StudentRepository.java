package com.igorkunicyn.student.repositories;

import com.igorkunicyn.student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
