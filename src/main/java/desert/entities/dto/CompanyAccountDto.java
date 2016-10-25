package desert.entities.dto;

import desert.entities.CompanyAccount;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Dim Mesh on 16.10.2016.  16:36
 */
public class CompanyAccountDto extends AccountDto implements Serializable  {
    private @Getter @Setter String companyName;
    private @Getter @Setter String contactName;
    private @Getter @Setter long numOfEmployee;

    public CompanyAccountDto(){
        setType(TypesOfAccounts.COMPANY);
    }

    public CompanyAccountDto(CompanyAccount account) {
        setType(TypesOfAccounts.COMPANY);
        this.id = account.getId();
        this.numOfEmployee = account.getNumOfEmployee();
        this.contactName = account.getContactName();
        this.companyName = account.getCompanyName();
    }
}
