package desert.entities;

/**
 * Created by Dim Mesh on 16.10.2016.  14:41
 */
interface Account {

    long getId();
    void setId(long id);

    void setUser(User user);
    User getUser();
}
