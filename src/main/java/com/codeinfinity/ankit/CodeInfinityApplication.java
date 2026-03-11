package com.codeinfinity.ankit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CodeInfinityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeInfinityApplication.class, args);
	}
}
