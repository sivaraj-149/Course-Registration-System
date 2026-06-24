package com.siva.placementportal.controller;
import com.siva.placementportal.model.Course;
import com.siva.placementportal.model.CourseRegistry;
import com.siva.placementportal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class CourseController {
    @Autowired
    CourseService courseService;
    @GetMapping("/courses")
    public List<Course> availableCourse(){
        return courseService.availableCourse();
    }
    @GetMapping("/courses/enrolledStudents")
    public List<CourseRegistry> enrolledStudents(){
        return courseService.enrolledStudents();
    }
    @PostMapping("/courses/register")
    public String courseEnroll(@RequestParam("name") String name,
                                @RequestParam("email") String email,
                               @RequestParam("courseName") String courseName){
        courseService.courseEnroll(name,email,courseName);
        return "redirect:/students";
    }
}
