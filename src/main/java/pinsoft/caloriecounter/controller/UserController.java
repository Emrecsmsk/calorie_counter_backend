package pinsoft.caloriecounter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pinsoft.caloriecounter.core.utilities.results.Result;
import pinsoft.caloriecounter.core.utilities.results.SuccessResult;
import pinsoft.caloriecounter.model.User;
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
    Result signUp(@DateTimeFormat(pattern= "MM-dd-yyyy") @RequestBody User user){


        return userService.signUp(user);
    }

    @PutMapping("/editUser")
    public Result editUser(@DateTimeFormat(pattern= "MM-dd-yyyy") @RequestBody User user){

        return userService.editUser(user);
    }

    @DeleteMapping("/deleteUser")
    Result deleteUser(int id){
        return userService.deleteUser(id);
    }


}
//
