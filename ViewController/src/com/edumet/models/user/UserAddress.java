package com.edumet.models.user;

public class UserAddress {
    
    private String street1;
    private String street2;
    private String street3;
    private String city;
    private String state;
    private String zip;
    private String telePhone;
    public UserAddress() {
        super();
    }

    public UserAddress(String street1, String street2, String street3, String city, String state, String zip,String telePhone) {
        super();
        this.street1 = street1;
        this.street2 = street2;
        this.street3 = street3;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.telePhone = telePhone;
    }

     

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getStreet3() {
        return street3;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getTelePhone() {
        return telePhone;
    }
}
