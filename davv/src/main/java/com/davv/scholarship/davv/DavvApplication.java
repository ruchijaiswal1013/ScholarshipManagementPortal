package com.davv.scholarship.davv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class DavvApplication {

	public static void main(String[] args) {
		SpringApplication.run(DavvApplication.class, args);
	}

	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasenames("classpath:/messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}

}
