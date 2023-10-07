package com.issuemoa.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class IssueMoaBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssueMoaBoardApplication.class, args);
	}

}
