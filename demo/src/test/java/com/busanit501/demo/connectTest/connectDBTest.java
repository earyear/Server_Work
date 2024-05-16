package com.busanit501.demo.connectTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectDBTest {

    @Test
    public void test() {
        int v1 = 100;
        int v2 = 100;

        Assertions.assertEquals(v1, v2);
    }

    @Test
    public void connectDBTest() throws Exception{
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
