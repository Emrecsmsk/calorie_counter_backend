package pinsoft.caloriecounter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pinsoft.caloriecounter.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
}
