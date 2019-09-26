package com.franco.vm.db;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class MyConnectionProvider {
    @Resource(lookup = "java:/vmDS")
    DataSource dataSource;

    @Produces
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();

    }

}
