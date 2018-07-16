package com.students.students.controller;

import com.students.students.entity.Student;
import com.students.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HelloController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(
    @RequestParam String name,
    Model model) {
        model.addAttribute("name", name);

        List<Student> students = (List<Student>) studentRepository.findAll();

        Student student = studentRepository.findById((long) 1).get();

        model.addAttribute("students", students);

        return "hello";
    }

    @RequestMapping(value = "/crate/student", method = RequestMethod.GET)
    public String createStudent(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname) {

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);

        studentRepository.save(student);

        return "created";
    }
}
