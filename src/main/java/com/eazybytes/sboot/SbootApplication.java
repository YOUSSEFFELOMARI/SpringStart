package com.eazybytes.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.eazybytes.sboot.model")
@EnableJpaRepositories("com.eazybytes.sboot.repository")
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImpl")
public class SbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootApplication.class, args);
	}

}
