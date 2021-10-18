package com.example.toy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Date;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(Date.class);

        docket = docket.select().apis(RequestHandlerSelectors.basePackage("com.example.toy.api")).paths(PathSelectors.any()).build();

        return docket;
    }

    public ApiInfo apiInfo() {
        return new ApiInfo(
                "ToyProject"
                ,"B-E APIS"
                , "v0.1"
                , ""
                , new Contact("reference","","")
                , ""
                ,""
                , Collections.emptyList()
        );
    }
}
