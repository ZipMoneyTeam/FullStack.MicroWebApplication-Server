package mainApp;

//import org.h2.server.web.WebServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	ServletRegistrationBean h2servletRegistration() {
//		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
//		registrationBean.addUrlMappings("/console/*");
//		return registrationBean;
//	}



}


