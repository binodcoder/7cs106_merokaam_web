package com.binodcoder.merokaam;

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
	public CommandLineRunner commandLineRunner(String[] args){
		return runner->{
			System.out.println("Hello World");
		};
	}
}
