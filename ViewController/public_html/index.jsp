<?xml version='1.0' encoding='ISO-8859-1'?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0" xmlns:f="http://java.sun.com/jsf/core"
          xmlns:h="http://java.sun.com/jsf/html">
    <jsp:directive.page contentType="text/html;charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="css/edumet.css" media="screen"/>
    <body bgcolor="#E0FFFF" title="Edumet Employee Web Portal">
        <f:view>
            <table bgcolor="#E0FFFF" class="center">
                  <tr><td><h1>Employee Portal Login </h1></td></tr>
            </table>
            <h:panelGrid width="100%"  bgcolor="E0FFFF">
                <h:form>
                    <f:facet name="header">
                        <h:outputText value="Login Panel"/>
                    </f:facet>
                    <!--          <table width="1500" align="center" cellpadding="0" cellspacing="1" bgcolor="#E0FFFF"
                           class="center">
                        <tbody>
                           <tr>
                                <td width="397" bgcolor="#E0FFFF">
                                     <div>
                                        <img src="images/edumet.jpg" width="1000" height="40" align="absmiddle"></img>
                                    </div> 
                                </td>
                            </tr> 
                        </tbody>
                    </table> -->
                    <table bgcolor="#E0FFFF" class="center">
                        <tbody>
                            <tr>
                                <td width="100%" bgcolor="#E0FFFF">
                                    <h:outputText value="Username "/>
                                     
                                    <h:inputText id="username" value="#{UserInfoBean.userName}" styleclass="inputbox"/>
                                     
                                    <h:outputText value=""/>
                                     
                                    <h:message for="username" styleclass="errors"></h:message>
                                     
                                    <h:outputText value="Password "/>
                                     
                                    <h:inputSecret id="password" value="#{UserInfoBean.password}"
                                                   styleclass="inputbox"/>
                                     
                                    <h:outputText value=""/>
                                     
                                    <h:message for="password" styleclass="errors"/>
                                     
                                    <h:commandButton value="Login" action="#{UserInfoBean.SimpleAuthenticateUser}"
                                                     styleclass="submitButton"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <a href="ForgottenUserName.faces">Forgotten Username</a>
                </h:form>
            </h:panelGrid>
        </f:view>
    </body>
</jsp:root>