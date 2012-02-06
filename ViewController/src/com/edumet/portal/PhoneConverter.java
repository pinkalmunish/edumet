package com.edumet.portal;


import com.edumet.models.user.PhoneNumber;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;


public class PhoneConverter implements Converter, Serializable {
    private static Logger log = Logger.getLogger(PhoneConverter.class);

    public PhoneConverter() {
        super();
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        return null;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        PhoneNumber phoneNumber = null;
        log.info("Begin getAsString");
        if (value instanceof PhoneNumber) {
            phoneNumber = (PhoneNumber)value;

            StringBuilder phoneNumberAsString = new StringBuilder();
            phoneNumberAsString.append(phoneNumber.getCountryCode() + "-");
            phoneNumberAsString.append(phoneNumber.getAreaCode() + "-");
            phoneNumberAsString.append(phoneNumber.getNumber());
            return phoneNumberAsString.toString();
        } else if (value instanceof String) {

            String phoneNum = (String)value;
            if (phoneNum != null && phoneNum.length() == 10) {
                String areaCode = phoneNum.substring(0, 3) + "-";
                String excCode = phoneNum.substring(3, 6) + "-";
                String number = phoneNum.substring(6, 10);
                return areaCode + excCode + number;

            }

        }
        return "";
    }
}
