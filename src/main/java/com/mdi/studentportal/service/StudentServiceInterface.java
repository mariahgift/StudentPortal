package com.mdi.studentportal.service;

import com.mdi.studentportal.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServiceInterface {
    String addStudent(String firstName, String lastName, String course, String email, Double GPA);
    List<Student> findAllStudents();
    Optional<Student> findStudentsById(Integer id);

    Student updateStudent(Student newStudent, Integer id);

    void deleteStudent(Integer id);
}
