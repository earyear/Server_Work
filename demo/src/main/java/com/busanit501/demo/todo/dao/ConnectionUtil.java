package com.busanit501.demo.todo.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;


public enum ConnectionUtil {
    INSTANCE;

    //주입 (다른 데이터 소스(다른 인스턴스)를 가져와서 이용하는 법)
    private HikariDataSource dataSource;

    ConnectionUtil() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");

        //옵션(기본값을 사용하고, 배포시 디비서버만 단독으로 사용할때, 메모리양을 정함
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        //선언만 한 인스턴스를 여기서 초기화
        dataSource = new HikariDataSource(config);
    }

    //Connection 리턴
    public Connection getConnection() throws Exception {
        return  dataSource.getConnection();
    }



}
