package com.edumet.portal.config;


import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class DatabaseTemplate {

    static String url = "jdbc:oracle:thin:@74.92.75.133:1521:";
    static String dbName = "web";
    static String driver = "oracle.jdbc.driver.OracleDriver";
    static String userName = "edumet";
    static String password = "edumet";
    private static Logger log = Logger.getLogger(DatabaseTemplate.class);
    private static ApplicationContext context =
        new ClassPathXmlApplicationContext("com/edumet/portal/config/applicationContext.xml");
    

    public DatabaseTemplate() {
        super();
    }

    public static Connection getConnection() {

        return getJNDIConnection();


    }
    private static Connection getJNDIConnection(){
    String DATASOURCE_CONTEXT = "EdumetDataSource";
    
    Connection result = null;
    try {
      Context initialContext = new InitialContext();
      if ( initialContext == null){
        log.error("JNDI problem. Cannot get InitialContext.");
      }
      DataSource datasource = (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
      if (datasource != null) {
        result = datasource.getConnection();
      }
      else {
        log.error("Failed to lookup datasource.");
      }
    }
    catch ( NamingException ex ) {
      log.error("Cannot get connection: " + ex);
    }
    catch(SQLException ex){
      log.error("Cannot get connection: " + ex);
    }
    return result;
  }
    
    public static void closeConnection(Connection conn){
        try{
            if(conn!=null && !conn.isClosed()){
                 
                conn.close();
            }
        }catch(SQLException se){
            //not recoverable
            log.error(se,se);   
        }
        
    }
}
