package com.siva.placementportal.controller;

import org.springframework.ui.Model;
import com.siva.placementportal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    private CourseService courseService;


    @GetMapping("/")
    public String home(Model model){

        model.addAttribute(
                "courses",
                courseService.availableCourse()
        );
        return "register";
    }

    @GetMapping("/students")
    public  String showStudents(Model model){
        model.addAttribute(
                "students",
                courseService.enrolledStudents()
        );
        return "enrolledStudents";
    }
}
