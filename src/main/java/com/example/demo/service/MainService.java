package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MainService {
    Student getStudentById(int id);
    void saveStudent(Student student);
    List<Student> getStudents();
}
