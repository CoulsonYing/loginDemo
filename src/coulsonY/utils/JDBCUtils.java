package coulsonY.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC的工具类，用来获得DataSource和Connedtion对象
 */
public class JDBCUtils {
    private JDBCUtils(){}

    private static  DataSource ds = null;
    // 利用静态代码块加载配置文件，获得数据库连接池对象
    static{
        try{
            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("druidConfig.properties");
            Properties pro = new Properties();
            pro.load(in);
            ds = DruidDataSourceFactory.createDataSource(pro);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池对象
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
