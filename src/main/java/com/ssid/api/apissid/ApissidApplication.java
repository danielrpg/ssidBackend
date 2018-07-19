package com.ssid.api.apissid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApissidApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApissidApplication.class, args);
	}

	 @Bean
	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
	  return new BCryptPasswordEncoder();
	 }
}
