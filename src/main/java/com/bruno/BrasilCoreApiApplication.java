package com.bruno;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bruno")
public class BrasilCoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrasilCoreApiApplication.class, args);
	}
}
