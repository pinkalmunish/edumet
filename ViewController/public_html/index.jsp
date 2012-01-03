<?xml version='1.0' encoding='ISO-8859-1'?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0" xmlns:f="http://java.sun.com/jsf/core"
          xmlns:h="http://java.sun.com/jsf/html">
    <jsp:directive.page contentType="text/html;charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="css/edumet.css" media="screen"/>
    <body bgcolor="#E0FFFF" title="Edumet Employee Web Portal">
        <f:view>
            <div id="header2">
                <h1>Employee Portal Login</h1>
            </div>
            <h:panelGrid width="100%" bgcolor="#E0FFFF">
                <h:form id="loginForm">
                    <f:facet name="header">
                        <h:outputText value="Login Panel"/>
                    </f:facet>
                    <div id="maincontainer">
                        <div class="errors">
                            <h:message for="loginForm" style="errors"/>
                        </div>
                        
                        <div>
                            <h:outputText value="Username "/>
                             
                            <h:inputText id="username" value="#{UserInfoBean.userName}" style="inputbox"/>
                             
                            <h:outputText value=""/>
                        </div>
                        <div>
                            <h:outputText value="Password "/>
                             
                            <h:inputSecret id="password" value="#{UserInfoBean.password}" style="inputbox"/>
                             
                            <h:outputText value=""/>
                        </div>
                        <div>
                            <h:commandButton value="Login" action="#{UserInfoBean.SimpleAuthenticateUser}"
                                             style="submitButton"/>
                        </div>
                    </div>
                    <div id="footer">
                        <a href="ForgottenUserName.faces">Forgotten Password?</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="HelpDoc.pdf">Help</a>
                    </div>
                </h:form>
            </h:panelGrid>
        </f:view>
    </body>
</jsp:root>