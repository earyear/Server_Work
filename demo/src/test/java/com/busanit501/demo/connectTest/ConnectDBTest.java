package com.busanit501.demo.connectTest;

import com.busanit501.demo.todo.domain.TodoVo;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

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

        System.out.println(conn);
        conn.close();
    }

    @Test
    public void test2() {

        TodoVo todo2 = new TodoVo();
        todo2.setTno(100L);
        todo2.setTitle("제목");
        todo2.setDueDate(LocalDate.now());

        System.out.println(todo2);


        TodoVo todo = TodoVo.builder()
                .tno(100L)
                .title("제목")
                .dueDate(LocalDate.now())
                .build();

        System.out.println(todo);

    }

    @Test
    public void test() {
        int v1 = 100;
        int v2 = 100;

        Assertions.assertEquals(v1, v2);
    }

    @Test
    public void connectTestDB() throws Exception{
        //JDBC 드라이버 로드
        Class.forName("org.mariadb.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/webdb",
                "webuser",
                "webuser "
        );

        //드라이버 설치 확인
        Assertions.assertNotNull(conn);

        conn.close();
    }
}
