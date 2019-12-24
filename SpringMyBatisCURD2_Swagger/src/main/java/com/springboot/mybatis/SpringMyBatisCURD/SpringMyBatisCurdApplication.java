package com.springboot.mybatis.SpringMyBatisCURD;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.springboot.mybatis.domain.Employee;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MappedTypes(Employee.class)
@MapperScan("com.springboot.mybatis.mapper")
@ComponentScan("com.springboot.mybatis")
@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class SpringMyBatisCurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMyBatisCurdApplication.class, args);
		//AbstractApplicationContext context = new ClassPathXmlApplicationContext("taskSchedular.xml");
	}
	
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.springboot.mybatis")).build();
	   }
   
	///http://localhost:8080/SpringMyBatisCURD/swagger-ui.html   for Swagger UI
}
