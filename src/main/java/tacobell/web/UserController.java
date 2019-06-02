package tacobell.web;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tacobell.User;
import tacobell.data.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/userList")
public class UserController {
    //Logger log = LoggerFactory.getLogger("tacobell.web.UserController");


    private UserRepository userRepo;

    @Autowired
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    //@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "There is no such user")
    public static class ThereIsNoSuchUserException extends RuntimeException {
    }

    @GetMapping//("{id}")
    public ResponseEntity<List> get(@RequestParam(value = "id") long id) {
        log.info("Searching for user");
        List<User> list = new ArrayList<>();
        /* User user = userRepo.findById(id);
        if (user == null) {
            throw new ThereIsNoSuchUserException();
        } else {
            list.add(user);
        } */

        list = Lists.newArrayList(userRepo.findAll()); // Guava library

        //LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        //StatusPrinter.print(lc);
        //return userRepo.findByUsername(name);

        //return new ResponseEntity<>(user,  HttpStatus.OK);

        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(list);
    }
}
