package com.example.simplemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(
    exclude = {
        SecurityAutoConfiguration.class
    }
)
@EnableSwagger2
public class SimpleMicroserviceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SimpleMicroserviceApplication.class, args);
  }

}

