package com.example.demo.mapper;

import com.example.demo.dao.entity.StudentEntity;
import com.example.demo.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

   public Student mapToDto(StudentEntity studentEntity) {
       return new Student(
               studentEntity.getFirstName(),
               studentEntity.getLastName(),
               studentEntity.getAge(),
               studentEntity.getBirthDate()
       );
   }

   public StudentEntity mapToEntity(Student student) {
       return new StudentEntity(
               null,
               student.getFirstName(),
               student.getLastName(),
               student.getAge(),
               student.getBirthDate()
       );
   }
}
