package desert.services;

import desert.entities.CompanyAccount;
import desert.entities.EmployeeAccount;
import desert.entities.User;
import desert.entities.dto.CompanyAccountDto;
import desert.entities.dto.EmployeeAccountDto;

/**
 * Created by Dim Mesh on 17.10.2016.  22:10
 */
public interface AccountsService {
    CompanyAccount createCompanyAccount(User user, CompanyAccountDto dto);

    EmployeeAccount createEmployeeAccount(User user, EmployeeAccountDto dto);
}
