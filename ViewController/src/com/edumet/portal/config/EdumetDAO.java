package com.edumet.portal.config;


import org.apache.commons.dbcp.BasicDataSource;

public class EdumetDAO {
    
    private BasicDataSource dataSource;
    public EdumetDAO() {
        super();
    }


    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}
