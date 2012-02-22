<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/edumet.css" media="screen"/>
        <script type="text/javascript" src="scripts/accordion.js">
 < 
        </script>
    </head>
    <body bgcolor="#E0FFFF">
        <f:view>
            <h:form id="employeeDashBoard">
                <div id="dashBoardContainer">
                    <h3 align="center" id="schoolTitle">
                        <h:outputText value="#{UserInfo.schoolDistrict}"/>
                    </h3>
                     
                    <h4 align="left" style="color:maroon">
                        Welcome
                        <h:outputText value="#{UserInfo.firstName}"/>
                        !
                    </h4>
                    <div>
                        <p class="back" align="right">
                            <h:commandButton value="Logout" action="#{UserInfo.logOut}" styleClass="LinkButton"></h:commandButton>
                        </p>
                    </div>
                    <div class="horizontalaccordion">
                        <ul>
                            <li>
                                <h3>My Information</h3>
                                <div style="color:blue">
                                    <b style="color:blue">First Name:</b>
                                     
                                    <h:outputText value="#{UserInfo.firstName} "/>
                                     
                                    <br></br>
                                     
                                    <b style="color:blue">Last Name:</b>
                                     
                                    <h:outputText value="#{UserInfo.lastName}"/>
                                     
                                    <br></br>
                                     
                                    <b style="color:blue">Employee State Id:</b>
                                     
                                    <h:outputText value="#{UserInfo.empStateId}"/>
                                     
                                    <br></br>
                                     
                                    <b style="color:blue">Telephone:</b>
                                     
                                    <h:outputText value="#{UserInfo.userAddress.telePhone}">
                                        <f:converter converterId="PhoneNumberConverter"></f:converter>
                                    </h:outputText>
                                     
                                    <br></br>
                                     
                                    <b style="color:blue">Annual Salary:</b>
                                     
                                    <h:outputText value="#{UserInfo.totalSalary}">
                                        <f:convertNumber currencySymbol="$" groupingUsed="#{true}" maxFractionDigits="2"
                                                         type="currency"></f:convertNumber>
                                    </h:outputText>
                                     
                                    <br></br>
                                     
                                    <b style="color:blue;text-align:left">Street:</b>
                                     
                                    <h:outputText value="#{UserInfo.userAddress.street1}"/>
                                     
                                    <br></br>
                                     
                                    <b style="color:blue">City:</b>
                                     
                                    <h:outputText value="#{UserInfo.userAddress.city}"/>
                                     
                                    <br></br>
                                     
                                    <b style="color:blue">State:</b>
                                     
                                    <h:outputText value="#{UserInfo.userAddress.state}"/>
                                     
                                    <br></br>
                                     
                                    <b style="color:blue">zip:</b>
                                     
                                    <h:outputText value="#{UserInfo.userAddress.zip}"/>
                                     
                                    <br></br>
                                </div>
                            </li>
                             
                            <li>
                                <h3>Pay Stubs</h3>
                                <rich:calendar cellWidth="20px" cellHeight="20px" style="width:150px;height:100px"
                                                buttonLabel="select pay day"></rich:calendar>
                            </li>
                             
                            <li>
                                <h3>W2 Information</h3>
                                <h:panelGrid>
                                    <h3>W2</h3>
                                    <h:dataTable id="yearlyW2B" value="#{UserInfo.w2Models}" var="w2"
                                                 rowClasses="list-row-odd, list-row-even" headerClass="table-header"
                                                 styleClass="bordered">
                                        <h:column id="col_name">
                                            <h:commandButton value="#{w2.year}" action="#{w2.onClick}"
                                                             styleClass="LinkButton"/>
                                        </h:column>
                                    </h:dataTable>
                                </h:panelGrid>
                            </li>
                             
                            <li>
                                <h3>Human Resources</h3>
                                <div>
                                    <h:commandButton value="Vacation Days" styleClass="LinkButton"/>
                                     
                                    <br></br>
                                     
                                    <h:commandButton value="Pay Statements" styleClass="LinkButton"/>
                                     
                                    <br></br>
                                     
                                    <h:commandButton value="Request Leave" styleClass="LinkButton"/>
                                     
                                    <br></br>
                                </div>
                            </li>
                             
                            <li>
                                <h3>Alerts</h3>
                                <div>
                                    <p style="color:red">No Alerts</p>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div></div>
                </div>
            </h:form>
        </f:view>
        <script type="text/javascript">
          var slider1 = new accordion.slider("slider1");
          slider1.init("slider");

          var slider2 = new accordion.slider("slider2");
          slider2.init("slider2", 0, "open");
        </script>
    </body>
</html>