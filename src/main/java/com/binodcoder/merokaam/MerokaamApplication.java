package com.binodcoder.merokaam;

import com.binodcoder.merokaam.dao.StudentDAO;
import com.binodcoder.merokaam.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			createStudent(studentDAO);
		};
	}
	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent=new Student("Binod", "Bhandari", "binodcoder@gmail.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}
}
