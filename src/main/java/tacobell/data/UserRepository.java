package tacobell.data;

import org.springframework.data.repository.CrudRepository;
import tacobell.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findById(long id);
}
