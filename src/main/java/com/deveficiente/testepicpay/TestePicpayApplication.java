package com.deveficiente.testepicpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TestePicpayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestePicpayApplication.class, args);
	}

}
