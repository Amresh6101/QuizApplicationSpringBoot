package com.quiz.management.application;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.logging.Logger;

@SpringBootApplication
//@Profile("dev")
//@Profile("uat")
public class QuizApplicationServiceApplication {

	public static final Logger log= Logger.getLogger("QuizApplicationServiceApplication.class");
	public static void main(String[] args)
	{
		SpringApplication.run(QuizApplicationServiceApplication.class, args);
		System.out.println(log);
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
