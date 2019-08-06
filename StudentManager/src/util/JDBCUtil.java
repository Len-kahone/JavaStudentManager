package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author 练家鸿
 * @Package util
 * @date 2019/8/5 9:50
 */
public class JDBCUtil {
    static ComboPooledDataSource source=null;
    static {
        source=new ComboPooledDataSource();
    }
   public static ComboPooledDataSource getSource(){
        return source;
    }
}
