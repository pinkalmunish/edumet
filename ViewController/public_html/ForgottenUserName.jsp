<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        </head>
        <body bgcolor="Silver">
            <h:form>
                <div>
                    <p>
                        <label>
                            Email address
                            <h:inputText id="username" value="#{RetrievePasswordBean.username}" styleclass="inputbox"/>
                        </label>
                    </p>
                </div>
                <p>
                    <h:commandButton value="Submit" action="#{RetrievePasswordBean.emailPassword}"
                                     styleclass="submitButton"/>
                </p>
            </h:form>
        </body>
    </html>
</f:view>