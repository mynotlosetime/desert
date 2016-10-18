package desert.entities.dto;

import desert.entities.CompanyAccount;

import java.io.Serializable;

/**
 * Created by Dim Mesh on 16.10.2016.  16:36
 */
public class CompanyAccountDto extends AccountDto implements Serializable  {
    private String companyName;
    private String contactName;
    private long numOfEmployee;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public long getNumOfEmployee() {
        return numOfEmployee;
    }

    public void setNumOfEmployee(long numOfEmployee) {
        this.numOfEmployee = numOfEmployee;
    }
}
