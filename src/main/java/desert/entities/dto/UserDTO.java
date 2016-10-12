package desert.entities.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import desert.entities.User;

import java.io.Serializable;

/**
 * Created by Dim Mesh on 12.10.2016.  20:40
 */

@JsonInclude(JsonInclude.Include.NON_NULL)

public class UserDto implements Serializable {
    private String name;
    private String password;
    private ProfileDto profile;

    public UserDto(){}

    public UserDto(User user){
        this.name = user.getUsername();
        this.password = user.getPassword();
        if(user.getProfile() != null){
            this.profile = new ProfileDto(user.getProfile());
        }
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ProfileDto getProfile() {
        return profile;
    }

    public void setProfile(ProfileDto profile) {
        this.profile = profile;
    }
}
