package tacobell.hello;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//класс представляющий ресурс
@Data
public class Greeting {
    @ApiModelProperty(notes = "This is ID") //property description
    private final long id;
    @ApiModelProperty(notes = "Greetings!!!")
    private final String content;
}
