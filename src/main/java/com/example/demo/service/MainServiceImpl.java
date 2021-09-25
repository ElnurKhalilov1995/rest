package com.example.demo.service;

import com.example.demo.dao.entity.StudentEntity;
import com.example.demo.dao.repository.StudentRepository;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MainServiceImpl implements MainService, AdditionalService{

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    public MainServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public Student getStudentById(int id) {
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        var student = optionalStudentEntity.orElseThrow(RuntimeException::new);

        return studentMapper.mapToDto(student);
    }

    @Override
    public void saveStudent(Student student) {
        System.out.println("Student by id " + student.getId() + " is saved");
    }

    @Override
    public String getAdditionalInfo() {
        return null;
    }
}
