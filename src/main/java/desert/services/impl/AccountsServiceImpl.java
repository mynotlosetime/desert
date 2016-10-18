package desert.services.impl;

import desert.entities.CompanyAccount;
import desert.entities.EmployeeAccount;
import desert.entities.User;
import desert.entities.dto.AccountDto;
import desert.entities.dto.CompanyAccountDto;
import desert.entities.dto.EmployeeAccountDto;
import desert.entities.repositories.CompanyAccountsRep;
import desert.entities.repositories.EmployeeAccountsRep;
import desert.services.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dim Mesh on 17.10.2016.  22:11
 */
@Component
public class AccountsServiceImpl implements AccountsService{
    @Autowired
    CompanyAccountsRep companyAccountsRep;

    @Autowired
    EmployeeAccountsRep employeeAccountsRep;

    @Override
    public CompanyAccount createCompanyAccount(User user, CompanyAccountDto dto){
        CompanyAccount account = new CompanyAccount(dto);
        account.setUser(user);
        companyAccountsRep.save(account);
        return account;
    }

    @Override
    public EmployeeAccount createEmployeeAccount(User user, EmployeeAccountDto dto) {
        EmployeeAccount account = new EmployeeAccount(dto);
        account.setUser(user);
        employeeAccountsRep.save(account);
        return account;
    }

    /*CompanyAccount updateCompanyAccount(long userId, CompanyAccountDto dto){
        companyAccountsRep.get
    }*/

}
