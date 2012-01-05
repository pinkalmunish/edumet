<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/edumet.css" media="screen"/>
    </head>
    <body bgcolor="#E0FFFF">
        <f:view>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
            <h:form id="forgottenPass">
                <div id="mainContainer">
                    <h1>Please Enter Your Email Address</h1>
                    
                        <h:message for="forgottenPass" style="error"/>
                  
                  
                        <label for="username">Email Address:  </label>
                         
                        <input name="username" id="username" class="field required" title="email address is required"
                               type="username"></input>
                   
                    <div class="submit">
                        <button type="submit">submit</button>
                    </div>
                    <div class="submit">
                        <h:commandLink value="Login" action="index.jsp"/>
                    </div>
                </div>
            </h:form>
        </f:view>
    </body>
</html>