package pinsoft.caloriecounter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pinsoft.caloriecounter.model.User;
import pinsoft.caloriecounter.repository.UserRepository;
import pinsoft.caloriecounter.service.UserService;



@RestController
@RequestMapping("/api/user")
public class UserController {
    UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/signup")
    void signUp(@DateTimeFormat(pattern= "MM-dd-yyyy") @RequestBody User user){
        userService.signUp(user);
    }

    @DeleteMapping("/deleteUser")
    void deleteUser(int id){
        userService.deleteUser(id);
    }


}
//
