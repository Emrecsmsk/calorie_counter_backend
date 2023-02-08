package pinsoft.caloriecounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pinsoft.caloriecounter.core.utilities.results.Result;
import pinsoft.caloriecounter.core.utilities.results.SuccessResult;
import pinsoft.caloriecounter.model.User;
import pinsoft.caloriecounter.repository.UserRepository;


@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result signUp(User user){
        userRepository.save(user);
        return new SuccessResult("Your account has been created.");

    }
    public Result editUser(User user){
        userRepository.saveAndFlush(user);
        return new SuccessResult();

    }

    public Result deleteUser(int id){
        userRepository.deleteById(id);
        return new SuccessResult();
    }


}
