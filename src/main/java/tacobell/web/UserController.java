package tacobell.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tacobell.User;
import tacobell.data.UserRepository;

@RestController
@RequestMapping("/userList")
public class UserController {

    private UserRepository userRepo;

    @Autowired
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping//("{id}")
    public User get(@RequestParam(value = "id") long id) {
        //return userRepo.findByUsername(name);
        return userRepo.findById(id);
    }


}
