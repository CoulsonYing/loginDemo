package coulsonY.dao.test;

import coulsonY.dao.UserDao;
import coulsonY.domain.User;
import org.junit.Test;

public class UserDaoTest {
    private User user= new User();

    @Test
    public void loginCheckTest(){
        user.setUsername("zhangsan");
        user.setPassword("z");
        User u = new UserDao().loginCheck(this.user);
        System.out.println(u);
    }
}
