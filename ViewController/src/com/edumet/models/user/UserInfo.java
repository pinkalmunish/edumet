package com.edumet.models.user;


import com.edumet.portal.config.DatabaseTemplate;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;


public class UserInfo implements Serializable {

    private String firstName;
    private String lastName;
    private String empStateId;
    private int totalSalary;
    private UserAddress userAddress;
    private String schoolDistrict;
    private boolean isLoggedIn;
    private String userName;
    private String password;
    private final static Logger log = Logger.getLogger(UserInfo.class);

    public UserInfo() {
        super();
        //        if (!isUserLoggedIn()) {
        //            try {
        //                FacesContext.getCurrentInstance().getExternalContext().redirect("loginMain.html");
        //            } catch (IOException ioe) {
        //                log.error(ioe, ioe);
        //            }
        //        }
    }

    public UserInfo(String firstname, String lastName, String empStateId, int totalSalary,
                    UserAddress userAddress) {
        super();
        this.firstName = firstname;
        this.lastName = lastName;
        this.empStateId = empStateId;
        this.totalSalary = totalSalary;
        this.userAddress = userAddress;
    }

    public UserInfo(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmpStateId(String empStateId) {
        this.empStateId = empStateId;
    }

    public String getEmpStateId() {
        return empStateId;
    }

    public void setTotalSalary(int totalSalary) {
        this.totalSalary = totalSalary;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setSchoolDistrict(String schoolDistrict) {
        this.schoolDistrict = schoolDistrict;
    }

    public String getSchoolDistrict() {
        return schoolDistrict;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

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
                int totalSalary = rs.getInt("EMP_TOTAL_SALARY");
                String stateId = rs.getString("EMP_STATE_ID");

                String street1 = rs.getString("EMP_STREET");
                String city = rs.getString("EMP_CITY");
                String state = rs.getString("EMP_STATE");
                String zipCode = rs.getString("EMP_ZIP_CODE");
                String telePhone = rs.getString("EMP_PHONE");
                String schoolDistrict = rs.getString("BOE");

                UserAddress userAddress = new UserAddress(street1, "", "", city, state, zipCode, telePhone);

                //this = new UserInfo(firstName, lastName, stateId, totalSalary, userAddress);
                this.setFirstName(firstName);
                this.setLastName(lastName);
                this.setEmpStateId(stateId);
                this.setTotalSalary(totalSalary);
                this.setUserAddress(userAddress);

                this.setSchoolDistrict(schoolDistrict);

                DatabaseTemplate.closeConnection(conn);
                this.setIsLoggedIn(true);
                FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                return "EmployeeDashBoard.html?faces-redirect=true";

            }
            DatabaseTemplate.closeConnection(conn);
            setIsLoggedIn(true);
            FacesContext.getCurrentInstance().addMessage("loginform",
                                                         new FacesMessage("Username/Password is incorrect"));

        } catch (SQLException se) {
            DatabaseTemplate.closeConnection(conn);
            log.error(se, se);


        }
        return "failure";

    }

    public String logOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        setIsLoggedIn(false);
        return "loginMain.html?faces-redirect=true";
    }

     

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
