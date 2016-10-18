package desert.entities;

import desert.entities.dto.CompanyAccountDto;

import javax.persistence.*;

/**
 * Created by Dim Mesh on 16.10.2016.  14:59
 */
@Entity
@Table(name = "company_accounts")
public class CompanyAccount implements Account{

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


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
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

    public Long getNumOfEmployee() {
        return numOfEmployee;
    }

    public void setNumOfEmployee(Long numOfEmployee) {
        this.numOfEmployee = numOfEmployee;
    }
}
