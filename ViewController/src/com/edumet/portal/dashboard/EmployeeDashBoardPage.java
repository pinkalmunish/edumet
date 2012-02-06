package com.edumet.portal.dashboard;


import com.edumet.models.user.UserInfo;

import java.io.IOException;
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
        if (!isUserLoggedIn()) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("loginMain.html");
            } catch (IOException ioe) {
                log.error(ioe, ioe);
            }
        }
    }

    public boolean isUserLoggedIn() {
        if (FacesContext.getCurrentInstance().getExternalContext().getSession(false) != null) {
            return true;
        }
        return false;
    }

    public String logOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        return "loginMain.html?faces-redirect=true";
    }


}
