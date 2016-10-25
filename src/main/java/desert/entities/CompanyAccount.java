package desert.entities;

import desert.entities.dto.CompanyAccountDto;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Dim Mesh on 16.10.2016.  14:59
 */
@Entity
@Table(name = "company_accounts")
public @Data class CompanyAccount implements Account{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne( mappedBy = "companyAccount", fetch = FetchType.LAZY )
    private User user;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "num_of_employee")
    private long numOfEmployee;

    public CompanyAccount(){}

    public CompanyAccount(String companyName, String contactName, long numOfEmployee ){
        this.companyName = companyName;
        this.contactName = contactName;
        this.numOfEmployee = numOfEmployee;
    }
    public CompanyAccount(CompanyAccountDto dto){
        this.companyName = dto.getCompanyName();
        this.contactName = dto.getContactName();
        this.numOfEmployee = dto.getNumOfEmployee();
    }
}
