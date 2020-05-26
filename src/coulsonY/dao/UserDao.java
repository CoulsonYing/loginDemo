package coulsonY.dao;

import coulsonY.domain.User;
import coulsonY.utils.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * UserDao类中对数据库进行操作，增删改查
 */
public class UserDao {
    // 因为会用到数据库，所以需要用到JdbcTemplate
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 对登录的用户信息与数据库中的进行比对
     * @param loginUser
     * @return
     */
    public User loginCheck(User loginUser){
        String sql = "SELECT * FROM t_user WHERE username = ? AND password = ?";
        User user = null;
        try{
            user = template.queryForObject(sql, // sql语句
                    new BeanPropertyRowMapper<>(User.class),    // 需要封装的Bean对象
                    loginUser.getUsername(), loginUser.getPassword()); // 需要传入的参数
        }catch(EmptyResultDataAccessException e){
            return user;
        }
        return user;
    }

}
