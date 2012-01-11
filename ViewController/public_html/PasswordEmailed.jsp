<?xml version='1.0' encoding='ISO-8859-1'?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0" xmlns:f="http://java.sun.com/jsf/core"
          xmlns:h="http://java.sun.com/jsf/html">
    <jsp:directive.page contentType="text/html;charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="css/edumet.css" media="screen"/>
    <body bgcolor="#E0FFFF" title="Edumet Employee Web Portal">
        <f:view>
            <html>
                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
                </head>
                <h:panelGrid width="100%" bgcolor="#E0FFFF">
                    <h:form id="passwordConfirmation">
                        <div id="mainContainer">
                            Thank You. A temporary password has been emailed to you
                            
                            <div id="footer">
                                <h:commandButton value="Login" action="loginMain.faces" style="submitButton"/>
                            </div>
                        </div>
                    </h:form>
                </h:panelGrid>
            </html>
        </f:view>
    </body>
</jsp:root>
 