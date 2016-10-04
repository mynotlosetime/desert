package desert.entities.repositories;

/**
 * Created by Dim Mesh on 29.09.2016.  22:05
 */


import desert.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
