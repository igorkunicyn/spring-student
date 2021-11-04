package com.igorkunicyn.student.servicies;

import com.igorkunicyn.student.entities.Student;
import com.igorkunicyn.student.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(Long id){
        return studentRepository.getById(id);
    }

    public List<Student> getListStudent(){
        return studentRepository.findAll();
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }
}
