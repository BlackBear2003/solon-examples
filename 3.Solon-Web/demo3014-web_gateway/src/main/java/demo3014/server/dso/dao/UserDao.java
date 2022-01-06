package demo3014.server.dso.dao;

import demo3014.common.UserModel;
import org.noear.solon.annotation.Component;

/**
 * @author noear 2021/4/22 created
 */
@Component
public class UserDao {

    public UserModel getUser() {
        UserModel user = new UserModel();
        user.setUserId(12);
        user.setNickname("noear");

        return user;
    }
}
