package com.edumet.models.user;

import java.io.Serializable;

public class UserInfo implements Serializable {
    
    private String firstName;
    private String lastName;
    private String empStateId;
    private String totalSalary;
    private UserAddress userAddress;
    private String schoolDistrict;
    
    public UserInfo() {
        super();
    }

    public UserInfo(String firstname, String lastName, String empStateId, String totalSalary,
                    UserAddress userAddress) {
        super();
        this.firstName = firstname;
        this.lastName = lastName;
        this.empStateId = empStateId;
        this.totalSalary = totalSalary;
        this.userAddress = userAddress;
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

    public void setTotalSalary(String totalSalary) {
        this.totalSalary = totalSalary;
    }

    public String getTotalSalary() {
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
}
