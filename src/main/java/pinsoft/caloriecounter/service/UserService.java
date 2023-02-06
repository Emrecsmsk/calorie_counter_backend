package pinsoft.caloriecounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pinsoft.caloriecounter.model.User;
import pinsoft.caloriecounter.repository.UserRepository;

import java.time.Year;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(User user){
        userRepository.save(user);

    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }


}
