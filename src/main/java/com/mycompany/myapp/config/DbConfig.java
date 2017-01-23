package com.mycompany.myapp.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xuy on 2017/1/23.
 */
@Configuration
public class DbConfig {

    @Bean(name = "ds1", destroyMethod = "close")
    public HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
        config.setUsername("root");
        config.setPassword("admin");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "512");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);
    }

    @Bean(name = "dsl1")
    public DSLContext dslContext() {
        return DSL.using(dataSource(), SQLDialect.MYSQL);
    }

    @Bean(name = "ds2", destroyMethod = "close")
    public HikariDataSource dataSource2() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/sakila");
        config.setUsername("root");
        config.setPassword("admin");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "512");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);
    }

    @Bean(name = "dsl2")
    public DSLContext dslContext2() {
        return DSL.using(dataSource2(), SQLDialect.MYSQL);
    }

}