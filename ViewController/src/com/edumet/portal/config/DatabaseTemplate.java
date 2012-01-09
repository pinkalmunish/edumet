package com.edumet.portal.config;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseTemplate {

    static String url = "jdbc:oracle:thin:@74.92.75.133:1521:";
    static String dbName = "web";
    static String driver = "oracle.jdbc.driver.OracleDriver";
    static String userName = "edumet";
    static String password = "edumet";

    private static ApplicationContext context =
        new ClassPathXmlApplicationContext("com/edumet/portal/config/applicationContext.xml");
    private static EdumetDAO edumetDAO = (EdumetDAO)context.getBean("EdumetDAO");
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(edumetDAO.getDataSource());

    public DatabaseTemplate() {
        super();
    }

    public static JdbcTemplate getConnection() {

        return jdbcTemplate;


    }
}
