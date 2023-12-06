package com.userinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UserInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserInformationApplication.class, args);
	}

}
