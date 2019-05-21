package tacobell.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Component
@ConfigurationProperties(prefix="taco.orders") //properties of that bean injected from spring environment
@Data
@Validated
public class OrderProps {

    @Min(value=0, message="must be between 5 and 25") //limit restrictions
    @Max(value=25, message="must be between 5 and 25")
    private int pageSize = 20; //deafult limit on displaying quantity of orders (current limit in application.yml)
}
