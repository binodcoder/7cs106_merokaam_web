package com.binodcoder.merokaam;
import com.binodcoder.merokaam.dao.StudentDAO;
import com.binodcoder.merokaam.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
//@SpringBootApplication(
//		scanBasePackages = {"com.binodcoder.merokaam",
//		"com.binodcoder.util"}
//)
@SpringBootApplication
public class MerokaamApplication {
    public static void main(String[] args) {
        SpringApplication.run(MerokaamApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
            //createMultipleStudents(studentDAO);
            //readStudent(studentDAO);
            queryForStudents(studentDAO);
        };
    }
    private void queryForStudents(StudentDAO studentDAO) {
        //get a list of students
        List<Student> theStudents=studentDAO.findAll();

        //display list of students
        for(Student tempStudent:theStudents){
            System.out.println(tempStudent);
        }


        //
    }
    private void readStudent(StudentDAO studentDAO) {

        Student student = studentDAO.findById(1);
        System.out.println("Found the student: "+ student);
    }
    private void createMultipleStudents(StudentDAO studentDAO) {
        //create multiple students object
        System.out.println("Creating 3 student objects ...");
        Student tempStudent1 = new Student("Binod", "Bhandari", "binodcoder@gmail.com");
        Student tempStudent2 = new Student("Ram", "Bhandari", "ramcoder@gmail.com");
        Student tempStudent3 = new Student("Hari", "Bhandari", "haricoder@gmail.com");
        //save the student objects
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
        //display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent1.getId());
        System.out.println("Saved student. Generated id: " + tempStudent2.getId());
        System.out.println("Saved student. Generated id: " + tempStudent3.getId());
    }
    private void createStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Binod", "Bhandari", "binodcoder@gmail.com");
        //save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);
        //display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
