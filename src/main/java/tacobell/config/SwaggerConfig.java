package tacobell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import static com.google.common.collect.Lists.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                /**After the Docket bean is defined, its select() method returns an instance of ApiSelectorBuilder,
                which provides a way to control the endpoints exposed by Swagger*/
                .select()
                /**Predicates for selection of RequestHandlers can be configured with the help of
                RequestHandlerSelectors and PathSelectors*/
                .apis(RequestHandlerSelectors.basePackage("tacobell"))
                //.apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                //Using any() for both will make documentation for your entire API available through Swagger
                .build()
                .apiInfo(apiInfo()) //information about API
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, //overriding defaullt response message
                        newArrayList(new ResponseMessageBuilder()
                                .code(404)
                                .message("404 Bad Taco Page")
                                .responseModel(new ModelRef("Error"))
                                .build()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Taco Bell",
                "Some custom description of API.",
                "API TOS",
                "Terms of service",
                new Contact("George", "www.tacobell.com", "tacobell@company.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
