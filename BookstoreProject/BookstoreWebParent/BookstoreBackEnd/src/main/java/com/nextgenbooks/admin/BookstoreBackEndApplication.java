package com.nextgenbooks.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.nextgenbooks.common.entity", "com.nextgenbooks.admin.user"})
public class BookstoreBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreBackEndApplication.class, args);
	}

}
