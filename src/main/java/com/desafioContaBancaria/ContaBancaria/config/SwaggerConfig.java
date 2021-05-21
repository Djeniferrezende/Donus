package com.desafioContaBancaria.ContaBancaria.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.desafioContaBancaria.ContaBancaria"))
                .paths(regex("/conta.*"))
                .build().apiInfo(metaInfo());
    }

    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo("Conta Bancaria Api Rest",
                "Api Rest Conta Bancaria",
                "1.0","Term of Service",
                new Contact("Djenifer Rezende",
                        "djeniferrezende", "djenifer.rezende@gmail.com"),
                "Apache Licence Version 2.0",
                "http://www.apache.org/licensen.html",new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }



}
