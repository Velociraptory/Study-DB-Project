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

    @GetMapping//("{id}")
    public User get(@RequestParam(value = "id") long id) {
        log.info("Searching for user");

        //LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        //StatusPrinter.print(lc);

        //return userRepo.findByUsername(name);
        return userRepo.findById(id);
    }


}
