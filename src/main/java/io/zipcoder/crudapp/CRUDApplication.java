package io.zipcoder.crudapp;

import ch.qos.logback.core.db.DriverManagerConnectionSource;
import org.h2.server.web.WebServlet;
import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.sql.DriverManager;

@SpringBootApplication
public class CRUDApplication {

	public static void main(String[] args) {
		SpringApplication.run(CRUDApplication.class, args);
	}

	@Bean
	ServletRegistrationBean h2servletRegistration(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}


}
