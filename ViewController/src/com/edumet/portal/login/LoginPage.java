package com.edumet.portal.login;


import com.edumet.models.user.UserAddress;
import com.edumet.models.user.UserInfo;
import com.edumet.portal.AppConstants;
import com.edumet.portal.config.DatabaseTemplate;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


@ManagedBean
@RequestScoped
public class LoginPage implements Serializable {

    private String userName;

    private String password;
    private final static Logger log = Logger.getLogger(LoginPage.class);
    private UserInfo userInfo;
    //Constructor

    public LoginPage() {

    }


    public String getPassword() {

        return password;

    }


    public void setPassword(String password) {

        this.password = password;

    }


    public String getUserName() {

        return userName;

    }


    public void setUserName(String userName) {

        this.userName = userName;

    }

    //Method to verify the user authentication


    public String SimpleAuthenticateUser() {

        Connection conn = null;
        log.warn("Calling Authetnicate User");
        try {

            conn = DatabaseTemplate.getConnection();
            String query =
                "select * from web_users wu, web_emp_demo we where wu.user_name = '" + userName + "' and wu.password =  '" +
                password + "' and we.emp_state_id = wu.emp_state_id(+)";
            log.info("Executing this query " + query);
            ResultSet rs = conn.createStatement().executeQuery(query);
            if (rs.next()) {
                String firstName = rs.getString("EMP_FIRST_NAME");
                String lastName = rs.getString("EMP_LAST_NAME");
                String totalSalary = rs.getString("EMP_TOTAL_SALARY");
                String stateId = rs.getString("EMP_STATE_ID");

                String street1 = rs.getString("EMP_STREET");
                String city = rs.getString("EMP_CITY");
                String state = rs.getString("EMP_STATE");
                String zipCode = rs.getString("EMP_ZIP_CODE");
                String telePhone = rs.getString("EMP_PHONE");
                String schoolDistrict = rs.getString("BOE");

                UserAddress userAddress = new UserAddress(street1, "", "", city, state, zipCode, telePhone);

                UserInfo userInfo = new UserInfo(firstName, lastName, stateId, totalSalary, userAddress);
                userInfo.setSchoolDistrict(schoolDistrict);
                this.userInfo = userInfo;
                DatabaseTemplate.closeConnection(conn);
                return "EmployeeDashBoard.html?faces-redirect=true";

            }
            DatabaseTemplate.closeConnection(conn);
            FacesContext.getCurrentInstance().addMessage("loginform",
                                                         new FacesMessage("Username/Password is incorrect"));

        } catch (SQLException se) {
            DatabaseTemplate.closeConnection(conn);
            log.error(se, se);


        }
        return "failure";

    }

    private void prepareUserSession(UserInfo user) {

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(false);
        httpSession.setAttribute(AppConstants.SESSION_USER_INFO, user);
    }


    public void setUserInfo(UserInfo userInfo) {
        

    }

    public UserInfo getUserInfo() {

        return userInfo;
    }
}
