package tacobell;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class JsonReader {
    public List<User> getUsers(String json){
        ObjectMapper mapper = new ObjectMapper();
        List<User> list = new ArrayList<>();
        try{
            //list = Arrays.asList(mapper.readValue(json, User[].class));

            User[] users = mapper.readValue(json, User[].class);
            list = new ArrayList<>(Arrays.asList(users));
        } catch (IOException e){
            log.warn(e.toString());
        }
        return list;
    }
}
