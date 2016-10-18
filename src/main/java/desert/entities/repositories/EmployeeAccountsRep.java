package desert.entities.repositories;

import desert.entities.EmployeeAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dim Mesh on 17.10.2016.  21:27
 */
public interface EmployeeAccountsRep extends JpaRepository<EmployeeAccount, Long> {

}
