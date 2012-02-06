package com.edumet.models.user;

import java.io.Serializable;

public class PhoneNumber implements Serializable {
    private int countryCode;
    private int areaCode;
    private long number;

    public String getNumberString() {
        return String.valueOf(countryCode) + String.valueOf(areaCode) + String.valueOf(number);
    }

    public PhoneNumber() {
    }

    public PhoneNumber(int countryCode, int areaCode, long number) {
        this.setCountryCode(countryCode);
        this.setAreaCode(areaCode);
        this.setNumber(number);
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
