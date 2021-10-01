package com.example.demo.controller.rest;

import com.example.demo.model.Student;
import com.example.demo.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentRestController {

    private final MainService mainService;

    public StudentRestController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int id){
        return mainService.getStudentById(id);
    }

    @PostMapping
    public void saveStudent(@RequestBody Student student) {
        mainService.saveStudent(student);
    }
}
