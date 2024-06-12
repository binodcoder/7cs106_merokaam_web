package com.binodcoder.merokaam.rest;
 import com.binodcoder.merokaam.entity.Teacher;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api")
public class TeacherRestController {
    private List<Teacher> theTeachers;
    //define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData() {
        theTeachers = new ArrayList<>();
        theTeachers.add(new Teacher("Ram", "Thapa"));
        theTeachers.add(new Teacher("Hari", "Gaire"));
        theTeachers.add(new Teacher("Binod", "Bhandari"));
    }
    //define endpoint for "/teachers" -return a list of teachers
    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        return theTeachers;
    }
    //define endpoint or "/teachers/{teacherId}" - return teacher at index
    @GetMapping("/teachers/{teacherId}")
    public Teacher getTeacher(@PathVariable int teacherId) {
        // just index into the list ... keep it simple for now
        return theTeachers.get(teacherId);
    }
}
