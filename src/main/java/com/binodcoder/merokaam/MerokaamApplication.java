package com.binodcoder.merokaam;
import com.binodcoder.merokaam.dao.StudentDAO;
import com.binodcoder.merokaam.entity.StudentEntity;
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
            //queryForStudents(studentDAO);
            //queryForStudentsByFirstName(studentDAO);
            //updateStudent(studentDAO);
            //deleteStudent(studentDAO);

           // deleteAllStudents(studentDAO);
        };
    }
    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numRowsDeleted=studentDAO.deleteAll();
        System.out.println("Deleted row count: "+numRowsDeleted);
    }
    private void deleteStudent(StudentDAO studentDAO) {
        int studentId=5;
        System.out.println("Deleting student id: "+studentId);
        studentDAO.delete(studentId);
    }
    private void updateStudent(StudentDAO studentDAO) {
        //retrieve student based on the id: primary key
        int studentId=1;
        System.out.println("Gettign student with id: "+studentId);
        StudentEntity myStudent=studentDAO.findById(studentId);

        //change first name to "Bire"
        System.out.println("Updating student...");
        myStudent.setFirstName("Bire");


        // update the student
        studentDAO.update(myStudent);

        //display the updated student
        System.out.println("updated student: "+myStudent);
    }
    private void queryForStudentsByFirstName(StudentDAO studentDAO) {
        //get a list of a students
        List<StudentEntity> theStudents=studentDAO.findByFirstName("Hari");

        //display list of students
        for(StudentEntity tempStudent: theStudents){
            System.out.println(tempStudent);
        }
    }
    private void queryForStudents(StudentDAO studentDAO) {
        //get a list of students
        List<StudentEntity> theStudents=studentDAO.findAll();

        //display list of students
        for(StudentEntity tempStudent:theStudents){
            System.out.println(tempStudent);
        }


        //
    }
    private void readStudent(StudentDAO studentDAO) {

        StudentEntity student = studentDAO.findById(1);
        System.out.println("Found the student: "+ student);
    }
    private void createMultipleStudents(StudentDAO studentDAO) {
        //create multiple students object
        System.out.println("Creating 3 student objects ...");
        StudentEntity tempStudent1 = new StudentEntity("Binod", "Bhandari", "binodcoder@gmail.com");
        StudentEntity tempStudent2 = new StudentEntity("Ram", "Bhandari", "ramcoder@gmail.com");
        StudentEntity tempStudent3 = new StudentEntity("Hari", "Bhandari", "haricoder@gmail.com");
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
        StudentEntity tempStudent = new StudentEntity("Binod", "Bhandari", "binodcoder@gmail.com");
        //save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);
        //display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
