package com.binodcoder.merokaam.rest;
import com.binodcoder.merokaam.entity.Teacher;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        //check the teacherId again list size
        if ((teacherId >= theTeachers.size()) || (teacherId < 0)) {
            throw new TeacherNotFoundException("Student id not found -" + teacherId);
        }
        return theTeachers.get(teacherId);
    }

    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<TeacherErrorResponse> handleException(TeacherNotFoundException exc) {
        //create a TeacherErrorResponse
        TeacherErrorResponse error = new TeacherErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //add another exception handler .. to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<TeacherErrorResponse> handleException(Exception exc){
        //create a TeacherErrorResponse
        TeacherErrorResponse error = new TeacherErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
