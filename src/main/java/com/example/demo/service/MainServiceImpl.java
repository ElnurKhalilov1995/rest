package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MainServiceImpl implements MainService{
    @Override
    public Student getStudentById(int id) {
        var students = new ArrayList<Student>();
        var student1 = new Student(1, "Elnur", "616.2");
        var student2 = new Student(2, "Emil", "616.3");
        var student3 = new Student(3, "Ilaha", "616.4");
        var student4 = new Student(4, "Fatima", "616.5");
        var student5 = new Student(5, "Nicat", "616.6");

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        var student = students.stream().filter((s) ->
            s.getId() == id
        ).findAny().get();

        return student;
    }

    @Override
    public void saveStudent(Student student) {
        System.out.println("Student by id " + student.getId() + " is saved");
    }
}
