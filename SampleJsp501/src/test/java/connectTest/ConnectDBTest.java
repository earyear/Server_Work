package connectTest;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectDBTest {

    @Test
    public void testHikariCP() throws Exception{
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");

        //옵션(기본값을 사용하고, 배포시 디비서버만 단독으로 사용할때, 메모리양을 정함
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        //연결확인 및 사용법
        HikariDataSource dataSource = new HikariDataSource(config);
        Connection conn=dataSource.getConnection();

        System.out.println("연결됨 : "+conn);
        conn.close();
    }

}
