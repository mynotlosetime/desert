package desert.entities.repositories;

import desert.entities.Profile;
import desert.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dim Mesh on 04.10.2016.  21:22
 */
public interface ProfilesRepository extends JpaRepository<Profile, Long> {


}
