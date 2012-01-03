<?xml version='1.0' encoding='ISO-8859-1'?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0" xmlns:f="http://java.sun.com/jsf/core"
          xmlns:h="http://java.sun.com/jsf/html">
    <jsp:directive.page contentType="text/html;charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="css/edumet.css" media="screen"/>
    <body bgcolor="#E0FFFF">
        <f:view>
            <html>
                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
                </head>
                <h:panelGrid width="100%" bgcolor="#E0FFFF">
                    <h:form id="forgottenUserNameForm">
                        <div id="maincontainer">
                            <h:message for="forgottenUserNameForm" styleclass="errors"/>
                             
                            <label>
                                Enter Email address
                                <h:inputText id="username" value="#{RetrievePasswordBean.username}"
                                             styleclass="inputbox"/>
                            </label>
                            <div>
                                <h:commandButton value="Submit" action="#{RetrievePasswordBean.emailPassword}"
                                                 styleclass="submitButton"/>
                                                 &nbsp;&nbsp;<h:commandButton value="Back" action="index.jsp"
                                                 styleclass="submitButton"/>
                            </div>
                        </div>
                    </h:form>
                </h:panelGrid>
            </html>
        </f:view>
    </body>
</jsp:root>
