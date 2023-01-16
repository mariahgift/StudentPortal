package com.mdi.studentportal.controller;

import com.mdi.studentportal.entity.Student;
import com.mdi.studentportal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Save Student
    @PostMapping("/addStudent")
    public String addStudent(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String course, @RequestParam String email, @RequestParam Double GPA) {
        return studentService.addStudent(firstName, lastName, course, email, GPA);
    }

    //Find Students
    @GetMapping("/students")
    List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    // Find
    @GetMapping("/student/{id}")
    public Optional<Student> findStudentsById(@PathVariable Integer id) {
        return studentService.findStudentsById(id);
    }

    //Update
    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student newStudent, @PathVariable Integer id) {
        return studentService.updateStudent(newStudent, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}
