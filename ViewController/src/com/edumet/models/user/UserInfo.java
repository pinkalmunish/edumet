package com.edumet.models.user;


import com.edumet.models.payroll.W2Model;
import com.edumet.portal.config.DatabaseTemplate;

import java.io.Serializable;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

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
    private List<W2Model> w2Models = new ArrayList<W2Model>();

    private final static Logger log = Logger.getLogger(UserInfo.class);

    public UserInfo() {
        super();

    }

    public UserInfo(String firstname, String lastName, String empStateId, int totalSalary, UserAddress userAddress) {
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

    public String authenticateUser() {

        Connection conn = null;
        PreparedStatement preparedStmt = null;
        ResultSet rs = null;
        log.warn("Calling Authetnicate User");
        boolean userAuthenticated = false;
        try {

            conn = DatabaseTemplate.getConnection();
            String query = "select * from web_users wu where wu.user_name = ? and wu.password = ?";
            log.info("Executing this query " + query);
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, userName);
            preparedStmt.setString(2, password);

            rs = preparedStmt.executeQuery();

            if (rs.next()) {
                userAuthenticated = true;
            }
            DatabaseTemplate.closeConnection(conn);
            setIsLoggedIn(true);


        } catch (SQLException se) {
            DatabaseTemplate.closeConnection(conn);
            log.error(se, se);


        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (preparedStmt != null) {
                    preparedStmt.close();
                }
            } catch (SQLException se) {
                log.error(se, se);
            }

        }
        if (userAuthenticated) {

            fetchData();
            fetchW2Models();
            this.setIsLoggedIn(true);
            FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            return "employeeDashBoard.html?faces-redirect=true";
        }
        FacesContext.getCurrentInstance().addMessage("loginform", new FacesMessage("Username/Password is incorrect"));
        return "failure";

    }

    private void fetchData() {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        try {
            String query =
                "select * from web_users wu, web_emp_demo we, web_emp_w2 w2 where wu.user_name = ?  and we.emp_state_id = wu.emp_state_id(+)";
            conn = DatabaseTemplate.getConnection();
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userName);
            log.info("executing query : " + query);
            rs = preparedStatement.executeQuery();
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


                this.setFirstName(firstName);
                this.setLastName(lastName);
                this.setEmpStateId(stateId);
                this.setTotalSalary(totalSalary);
                this.setUserAddress(userAddress);

                this.setSchoolDistrict(schoolDistrict);
            }


        } catch (SQLException se) {
            log.error(se, se);

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException se) {
                log.error(se, se);
            }

        }

    }

    private void fetchW2Models() {
        List<W2Model> w2Models = new ArrayList<W2Model>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            String query =
                "select * from web_users wu, web_emp_w2 w2 where wu.user_name = ? and w2.emp_state_id = wu.emp_state_id(+)";
            conn = DatabaseTemplate.getConnection();
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userName);
            log.info("executing query : " + query);
            rs = preparedStatement.executeQuery();

            W2Model w2Model;
            while (rs.next()) {
                w2Model = new W2Model();
                Blob fileData = rs.getBlob("EMP_W2");
                byte[] allBytesInBlob = fileData.getBytes(1, (int)fileData.length());
                w2Model.setStream(allBytesInBlob);
                w2Model.setYear(rs.getString("EMP_YEAR"));
                w2Models.add(w2Model);
            }

            DatabaseTemplate.closeConnection(conn);
        } catch (SQLException se) {
            log.error(se, se);
            DatabaseTemplate.closeConnection(conn);
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException se) {
                log.error(se, se);
            }

        }

        this.setW2Models(w2Models);


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

    public void setW2Models(List<W2Model> w2Models) {
        this.w2Models = w2Models;
    }

    public void addW2Model(W2Model w2Model) {
        w2Models.add(w2Model);
    }

    public List<W2Model> getW2Models() {
        return w2Models;
    }
}
