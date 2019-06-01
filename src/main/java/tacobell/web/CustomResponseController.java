package tacobell.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/customResponse")
public class CustomResponseController {

    @GetMapping
    ResponseEntity<String> hello() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");


        //return ResponseEntity.ok("Custom controller"); //simplest case is a response with a body and HTTP 200 response code
        //return new ResponseEntity<>("Custom controller", headers, HttpStatus.BAD_REQUEST);

        return ResponseEntity.badRequest()
                .header("Custom-Header", "foo")
                .body("Custom header set");
    }
}
