package com.edumet.portal.dashboard;


import com.edumet.models.user.UserInfo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;


@ManagedBean
@RequestScoped

public class EmployeeDashBoardPage implements Serializable{
    private UserInfo userInfo;
    private static Logger log = Logger.getLogger(EmployeeDashBoardPage.class);

    public EmployeeDashBoardPage() {

    }


    public void setUserInfo(UserInfo userInfo) {

        this.userInfo = userInfo;

    }

    public UserInfo getUserInfo() {
        return userInfo;
    }


}
