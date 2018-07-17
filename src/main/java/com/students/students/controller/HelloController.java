package com.students.students.controller;

import com.students.students.entity.Student;
import com.students.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students/list")
    public String sayHello(Model model) {
        List<Student> students = (List<Student>) studentRepository.findAll();

        Student student = studentRepository.findById((long) 1).get();

        model.addAttribute("students", students);

        return "list";
    }

    @GetMapping("/students")
    public String studentForm(Student student) {
        return "create-form";
    }

    @PostMapping("/students")
    public String createStudent(Student student) {

        studentRepository.save(student);

        return "redirect:students/list";
    }

}
