package com.gmail.v.varvaruk89.urltest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication

@EnableScheduling
public class UrltestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrltestApplication.class, args);
	}



}
