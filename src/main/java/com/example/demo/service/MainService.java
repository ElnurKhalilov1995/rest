package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface MainService {
    Student getStudentById(int id);
    void saveStudent(Student student);
}
