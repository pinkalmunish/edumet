<?xml version='1.0' encoding='ISO-8859-1'?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0" xmlns:f="http://java.sun.com/jsf/core"
          xmlns:h="http://java.sun.com/jsf/html">
    <jsp:directive.page contentType="text/html;charset=UTF-8"/>
    <!--  -->
    <html xmlns="http://www.w3.org/1999/xhtml">
        <head>
        <LINK rel="stylesheet" type="text/css" href="css/edumet.css" title="Default Styles" media="screen">
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
            <title>Login to Our Website</title>
            <meta name="description" content=""/>
            
                <body bgcolor="Gray" title="Edumet Employee Web Portal">
                    <f:view>
                        <h:form id="login">
                            <h1>
                                Log in to your
                                <strong>Employee Portal</strong>
                            </h1>
                            <div class="errors">
                                <h:message for="login" style="errors"/>
                            </div>
                            <div>
                                <label for="username">Username</label>
                                 
                                <h:inputText id="username" value="#{UserInfoBean.userName}" style="field required"/>
                                 
                                <h:outputText value=""/>
                                 
                                <h:message for="username" style="errors"></h:message>
                            </div>
                            <div>
                                <label for="password">Password</label>
                                 
                                <h:inputSecret id="password" value="#{UserInfoBean.password}" style="field required"/>
                                 
                                <h:outputText value=""/>
                                 
                                <h:message for="password" styleclass="errors"/>
                            </div>
                            <p class="forgot">
                                <a href="ForgottenUserName.faces">Forgot your password?</a>
                            </p>
                            <div class="submit">
                                <h:commandButton value="Login" action="#{UserInfoBean.SimpleAuthenticateUser}"/>
                            </div>
                            <label>
                                <input type="checkbox" name="remember" id="login_remember" value="yes"></input>
                                Remember my login on this computer
                            </label>
                        </h:form>
                    </f:view>
                </body>
            </LINK>
        </head>
    </html>
</jsp:root>