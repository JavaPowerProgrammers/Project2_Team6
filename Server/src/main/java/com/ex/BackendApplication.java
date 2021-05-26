package com.ex;

import com.ex.pojos.User;
import com.ex.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//public class BackendApplication {
public class BackendApplication implements CommandLineRunner {

	@Autowired
	private UserService service;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		User user = new User("ben", 32);
		service.save(user);

		//items

		//weapons

		//spells

		//DND classes

		//species

		//player characters

		//actions

		//rooms

	}

}
