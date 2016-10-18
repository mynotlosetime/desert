package desert.entities.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by Dim Mesh on 16.10.2016.  16:30
 */
class TypesOfAccounts {
    private TypesOfAccounts() { } // Prevents instantiation
    static final String COMPANY = "Company";
    static final String EMPLOYEE = "Employee";
}

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CompanyAccountDto.class, name = TypesOfAccounts.COMPANY),
        @JsonSubTypes.Type(value = EmployeeAccountDto.class, name = TypesOfAccounts.EMPLOYEE) })
public abstract class  AccountDto {

    long id;
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
