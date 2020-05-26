package coulsonY.utils.test;

import coulsonY.utils.JDBCUtils;
import org.junit.Test;

import java.sql.SQLException;

public class JDBCUtilsTest {

    @Test
    public void getDataSourceTest(){
        System.out.println(JDBCUtils.getDataSource());
    }

    @Test
    public void getConnectionTest() throws SQLException {
        System.out.println(JDBCUtils.getConnection());
    }
}
