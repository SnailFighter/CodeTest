package com.lzw.servicepro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.lzw.servicepro.**")
@EnableAutoConfiguration
public class SpringCloudProviderApplication {

	public static void main(String[] args) {
		//new SpringApplicationBuilder(SpringCloudProviderApplication.class).web(true).run(args);
		SpringApplication.run(SpringCloudProviderApplication.class, args);

	}



}
