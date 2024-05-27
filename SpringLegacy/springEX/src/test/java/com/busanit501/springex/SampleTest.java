package com.busanit501.springex;

import com.busanit501.springex.sample.SampleDAO;
import com.busanit501.springex.sample.SampleService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Log4j2
// 스프링 레거시에서 단위테스트 를 위한 설정 관련.
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTest {

    //DI
    //의존성 주입 하는 방법.
    // root-context.xml 파일에 설정된 빈이 있다면, 가져와서 주입 하겠다.
    @Autowired
    private SampleService sampleService;

    // DataSource 주입 테스트
    @Autowired
    private DataSource dataSource;

    @Qualifier("event")
    @Autowired
    private SampleDAO sampleDAO;

    @Test
    public void testService() {
        // 단순, 인스턴스를 시스템에서 생성해주는지 여부만 확인, null 만 아니면 된다.
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }

    @Test
    public void testDao() {
        // 단순, 인스턴스를 시스템에서 생성해주는지 여부만 확인, null 만 아니면 된다.
        log.info(sampleDAO);
        Assertions.assertNotNull(sampleDAO);
    }

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.info("connection"+connection);
        Assertions.assertNotNull(connection);
        connection.close();
    }

}







