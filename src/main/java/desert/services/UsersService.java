package desert.services;

import desert.entities.Profile;
import desert.entities.User;
import desert.entities.repositories.ProfilesRepository;
import desert.entities.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dim Mesh on 03.10.2016.  22:16
 */
@Component
public class UsersService {
    @Autowired
    UsersRepository users;

    @Autowired
    ProfilesRepository profiles;

    @Transactional
    public User addGuest(User user,String firstName, String lastName){

        Profile profile = new Profile(firstName,lastName);
        profile.setUser(user);
        profiles.save(profile);

        user.setProfile(profile);
        users.save(user);

        return user;
    }

    public Iterable<User> findAll(){
        return users.findAll();
    }
}
