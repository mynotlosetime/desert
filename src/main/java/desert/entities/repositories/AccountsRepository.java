package desert.entities.repositories;

import desert.entities.AccountEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dim Mesh on 04.10.2016.  21:22
 */
public interface AccountsRepository extends JpaRepository<AccountEmployee, Long> {


}
