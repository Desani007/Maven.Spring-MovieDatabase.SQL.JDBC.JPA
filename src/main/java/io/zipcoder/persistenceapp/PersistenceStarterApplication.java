package io.zipcoder.persistenceapp;



import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@ComponentScan("Service")
@ComponentScan("io.zipcoder.persistenceapp.Controller")
@SpringBootApplication
@EnableJpaAuditing
public class PersistenceStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistenceStarterApplication.class, args);
	}

	@Bean
	ServletRegistrationBean h2servletRegistration(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}



}
