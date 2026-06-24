package com.siva.placementportal.service;
import com.siva.placementportal.model.Course;
import com.siva.placementportal.model.CourseRegistry;
import com.siva.placementportal.repository.CourseRegistryRepo;
import com.siva.placementportal.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    CourseRegistryRepo courseRegistryRepo;
    public List<Course> availableCourse() {
        return courseRepo.findAll();
    }
    public List<CourseRegistry> enrolledStudents() {
        return courseRegistryRepo.findAll();
    }
    public void courseEnroll(String name, String email, String courseName) {
        courseRegistryRepo.save(new CourseRegistry(name,email,courseName));
    }
}
