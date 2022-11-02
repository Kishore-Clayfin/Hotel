package com.cf;


import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.cf.model.SpringSecurityAuditorAware;
import com.cf.service.EmailService;
import com.google.zxing.WriterException;


@EnableJpaAuditing(auditorAwareRef="auditorAware")
@SpringBootApplication
public class SpringbootDataJpa1Application //implements CommandLineRunner 
{
	
	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditorAware();
	}
	public static void main(String[] args) throws WriterException, IOException
	{
		
		SpringApplication.run(SpringbootDataJpa1Application.class, args);
		
		
		
	}


}
