package com.example.demo.service;

import com.example.demo.dao.entity.StudentEntity;
import com.example.demo.dao.repository.StudentRepository;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        var studentEntity = studentMapper.mapToEntity(student);
        studentRepository.save(studentEntity);
    }

    @Override
    public List<Student> getStudents() {
        var students = studentRepository.
                findAll().stream().
                map(studentEntity -> studentMapper.mapToDto(studentEntity))
                .collect(Collectors.toList());

        return students;
    }

    @Override
    public String getAdditionalInfo() {
        return null;
    }


}
