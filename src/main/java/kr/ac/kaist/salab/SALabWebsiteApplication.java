package kr.ac.kaist.salab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
public class SALabWebsiteApplication {
	public static void main(String[] args) {
		SpringApplication.run(SALabWebsiteApplication.class, args);
	}
}
