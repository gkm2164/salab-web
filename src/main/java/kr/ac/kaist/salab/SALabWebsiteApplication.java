package kr.ac.kaist.salab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
@EnableWebMvc
public class SALabWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SALabWebsiteApplication.class, args);
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setViewClass(JstlView.class);
		irvr.setPrefix("/WEB-INF/jsps/");
		irvr.setSuffix(".jsp");
		return irvr;
	}
}
