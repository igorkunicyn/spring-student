package com.igorkunicyn.student.controllers;

import com.igorkunicyn.student.entities.Student;
import com.igorkunicyn.student.servicies.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/add")
    public String showFormAddStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-add";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute(name = "student")Student student){
        studentService.saveStudent(student);
        return "redirect:/list";
    }
    @GetMapping("/showStudent/{id}")
    public String showStudentsById(@PathVariable(name = "id")Long id){
        Student student = studentService.getStudentById(id);
        if (student != null){
            return String.format("номер:= %d, имя: = %s, возраст:= %d", id, student.getName(), student.getAge());
        }
        return "Студент с номером " + id + "не существует";
    }

    @GetMapping("/list")
    public String showListStudent(Model model){
        List<Student> studentList = studentService.getListStudent();
        model.addAttribute("listStudents", studentList);
        return "student-list";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id")Long id) {
        ModelAndView modelAndView = new ModelAndView("student-edit");
        Student student = studentService.getStudentById(id);
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        Student student = studentService.getStudentById(id);
        studentService.deleteStudent(student);
        return "redirect:/list";
    }

}
