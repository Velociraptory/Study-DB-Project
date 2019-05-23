package hello;

import lombok.Data;

//класс представляющий ресурс
@Data
public class Greeting {
    private final long id;
    private final String content;
}
