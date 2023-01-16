package com.mdi.studentportal.service;

import com.mdi.studentportal.entity.Student;
import com.mdi.studentportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public String addStudent(String firstName, String lastName, String course, String email, Double GPA) {
        Student studentEntity = new Student();
        studentEntity.setFirstName(firstName);
        studentEntity.setLastName(lastName);
        studentEntity.setCourse(course);
        studentEntity.setEmail(email);
        studentEntity.setGPA(GPA);
        studentRepository.save(studentEntity);
        return "New student added!";
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentsById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Student newStudent, Integer id) {
        return studentRepository.findById(id)
                .map(x-> {
                    x.setFirstName(newStudent.getFirstName());
                    x.setLastName(newStudent.getLastName());
                    x.setCourse(newStudent.getCourse());
                    x.setEmail(newStudent.getEmail());
                    x.setGPA(newStudent.getGPA());
                    return studentRepository.save(x);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
