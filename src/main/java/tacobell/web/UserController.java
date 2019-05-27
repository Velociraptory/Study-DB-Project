package tacobell.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tacobell.User;
import tacobell.data.UserRepository;

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
    public class ThereIsNoSuchUserException extends RuntimeException {
    }

    @GetMapping//("{id}")
    public User get(@RequestParam(value = "id") long id) {
        log.info("Searching for user");
        User user = userRepo.findById(id);
        if (user == null) {
            throw new ThereIsNoSuchUserException();
        }

        //LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        //StatusPrinter.print(lc);
        //return userRepo.findByUsername(name);
            return user;
    }
}
