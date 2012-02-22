<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  -->
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link rel="stylesheet" type="text/css" href="css/edumet.css" title="Default Styles" media="screen"></link>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Login to Our Website</title>
        <meta name="description" content=""/>
    </head>
    <body bgcolor="Gray" title="Edumet Employee Web Portal">
        <f:view>
            <h:form id="loginform">
                <!-- <div id="mainContainer"> -->
                <div id="mainContainer">
                    <h1 align="center">
                        Log in to your
                        <strong>Employee Portal</strong>
                    </h1>
                     
                    <h2 align="center">
                        <h:message for="loginform" styleClass="errorsText"/>
                    </h2>
                    <div>
                        <label>Username</label>
                         
                        <h:inputText id="username" value="#{UserInfo.userName}" style="field required"/>
                    </div>
                    <div>
                        <label>Password</label>
                         
                        <h:inputSecret id="password" value="#{UserInfo.password}" style="field required"/>
                    </div>
                    <!--  <p class="forgot">
                        <a href="ForgottenUserName.html">Forgot your password?</a>
                    </p> -->
                    <div class="submit">
                        <h:commandButton value="Login" action="#{UserInfo.authenticateUser}" style="align:right"></h:commandButton>
                         &nbsp; 
                        <h:commandButton value="Forgotten Password" action="ForgottenUserName.html" style="align:right"></h:commandButton>
                    </div>
                    <div align="center">
                        <input type="checkbox" name="remember" id="login_remember" value="yes"></input>
                         Remember my login on this computer
                    </div>
                </div>
            </h:form>
        </f:view>
    </body>
</html>