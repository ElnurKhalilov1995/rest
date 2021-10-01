package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/students-table")
public class StudentController {
    private MainService mainService;

    public StudentController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping(value = {"", "/"})
    public String getStudents(Model model) {
        var students = mainService.getStudents();
        model.addAttribute("students", students);
        return "student-table";
    }

    @PostMapping("/add")
    public String saveStudent(@RequestBody Student student, Model model) {
        System.out.println(student.getFirstName());
        mainService.saveStudent(student);
        var students = mainService.getStudents();
        model.addAttribute("students", students);

        return "student-table";
    }

    @GetMapping("/student-update")
    public String studentUpdate() {
        return "student-update";
    }
}
