package tacobell.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tacobell.JsonReader;
import tacobell.User;
import tacobell.data.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customResponse")
public class CustomResponseController {

    private UserRepository userRepo;

    @Autowired
    public CustomResponseController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    ResponseEntity<List> customResponse(@RequestParam(value = "id") long id) {
        //HttpHeaders headers = new HttpHeaders();
        //headers.add("Custom-Header", "foo");

        List<User> inputList = new ArrayList<>();
        /* User user = userRepo.findById(id);
        if (user == null) {
            throw new UserController.ThereIsNoSuchUserException();
        } else {
            inputList.add(user);
        } */

        inputList = Lists.newArrayList(userRepo.findAll()); // Guava library

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(inputList);
        } catch (JsonProcessingException e) {
            log.warn(e.toString());
        }


        //return ResponseEntity.ok("Custom controller"); //simplest case is a response with a body and HTTP 200 response code
        //return new ResponseEntity<>("Custom controller", headers, HttpStatus.BAD_REQUEST);

        JsonReader jsonReader = new JsonReader();
        List<User> outputList = jsonReader.getUsers(json);

        log.info(outputList.toString());

        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(outputList);
    }
}
