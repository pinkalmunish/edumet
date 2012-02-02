package com.edumet.portal.dashboard;


import com.edumet.models.user.UserInfo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;


@ManagedBean
@RequestScoped

public class EmployeeDashBoardPage implements Serializable {
    private UserInfo userInfo;
    private static Logger log = Logger.getLogger(EmployeeDashBoardPage.class);

    public EmployeeDashBoardPage() {
        initData();
    }

    private void initData() {
        UserInfo object =
            (UserInfo)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("LoginPage.userInfo");
        if (object != null) {
            log.info("UserInfo is not null!!");
            log.info("first name " + object.getFirstName());
            setUserInfo(object);
        }
    }


    public void setUserInfo(UserInfo userInfo) {

        this.userInfo = userInfo;

    }

    public UserInfo getUserInfo() {
        return userInfo;
    }


}
