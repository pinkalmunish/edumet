<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
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
                <div id="mainContainer">
                    <h1>
                        Log in to your
                        <strong>Employee Portal</strong>
                    </h1>
                    <div>
                        <h:message for="loginform" style="error"/>
                    </div>
                    <div>
                        <label for="username">Username</label>
                         
                        <h:inputText id="username" value="#{LoginPage.userName}" style="field required"/>
                         
                        <h:outputText value=""/>
                    </div>
                    <div>
                        <label for="password">Password</label>
                         
                        <h:inputSecret id="password" value="#{LoginPage.password}" style="field required"/>
                         
                        <h:outputText value=""/>
                    </div>
                    <p class="forgot">
                        <a href="ForgottenUserName.html">Forgot your password?</a>
                    </p>
                    <div class="submit">
                        <h:commandButton value="Login" action="#{LoginPage.SimpleAuthenticateUser}">
                            <!--<f:setPropertyActionListener value="#{LoginPage.userInfo}"
                                                         target="#{EmployeeDashBoardPage.userInfo}" /> -->
                        </h:commandButton>
                    </div>
                    <label>
                        <input type="checkbox" name="remember" id="login_remember" value="yes"></input>
                        Remember my login on this computer
                    </label>
                </div>
            </h:form>
        </f:view>
    </body>
</html>