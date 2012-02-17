<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/edumet.css" media="screen"/>
        <script type="text/javascript" src="scripts/accordion.js">
  
        </script>
        <!--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script> -->
       <!-- <script type="text/javascript">
          horizontalaccordion.setup( {
              accordionid : 'hc2', //main accordion div id
              paneldimensions :  {
                  peekw : '30px', fullw : '450px', h : '150px'
              },
              selectedli : [0, true], //[selectedli_index, persiststate_bool]
              collapsecurrent : true//<- No comma following very last setting!
          })
        </script> -->
    </head>
    <body bgcolor="#E0FFFF">
        <f:view>
            <h:form id="employeeDashBoard">
                <div>
                    <!-- id="mainContainer"> -->
                    <h3 align="center">
                        <h:outputText value="#{UserInfo.schoolDistrict}"/>
                    </h3><!--<dl class="accordion" id="slider">
                        <dt>Alerts</dt>
                        <dd>No Alerts at this time</dd>
                        <dt>My Information</dt>
                        <dd>
                            <b>First Name:</b>
                            <h:outputText value="#{UserInfo.firstName}"/>
                            <br></br>
                            <b>Last Name:</b>
                            <h:outputText value="#{UserInfo.lastName}"/>
                            <br></br>
                            <b>Employee State Id:</b>
                            <h:outputText value="#{UserInfo.empStateId}"/>
                            <br></br>
                            <b>Telephone:</b>
                            <h:outputText value="#{UserInfo.userAddress.telePhone}">
                                <f:converter converterId="PhoneNumberConverter"></f:converter>
                            </h:outputText>
                            <br></br>
                            <b>Annual Salary:</b>
                            <h:outputText value="#{UserInfo.totalSalary}">
                                <f:convertNumber currencySymbol="$" groupingUsed="#{true}" maxFractionDigits="2"
                                                 type="currency"></f:convertNumber>
                            </h:outputText>
                            <br></br>
                            <b>Street:</b>
                            <h:outputText value="#{UserInfo.userAddress.street1}"/>
                            <br></br>
                            <b>City:</b>
                            <h:outputText value="#{UserInfo.userAddress.city}"/>
                            <br></br>
                            <b>State:</b>
                            <h:outputText value="#{UserInfo.userAddress.state}"/>
                            <br></br>
                            <b>zip:</b>
                            <h:outputText value="#{UserInfo.userAddress.zip}"/>
                            <br></br>
                        </dd>
                        <dt>Tax Information</dt>
                        <dd>
                            <h:dataTable id="yearlyW2" value="#{UserInfo.w2Models}" var="w2"
                                         rowClasses="list-row-odd, list-row-even" headerClass="table-header"
                                         styleClass="bordered">
                                <h:column id="col_name">
                                 <h:commandLink value="#{w2.year}" action="#{w2.onClick}"/>
                                </h:column>
                            </h:dataTable>
                            
                            
                        </dd>
                        <dt>Human Resources</dt>
                        <dd>
                            <h:commandLink value="Vacation Days"/>
                            <br></br>
                            <h:commandLink value="Payroll"/>
                            <br></br>
                            <h:commandLink value="Reports"/>
                            <br></br>
                        </dd>
                    </dl> -->
                    <div class="horizontalaccordion" align="center">
                        <ul>
                            <li>
                                <h3>My Information</h3>
                                <div>
                                    <b style="color:blue">First Name:</b>
                                     
                                    <h:outputText value="#{UserInfo.firstName}"/>
                                     
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
                                     
                                    <b style="color:blue">Street:</b>
                                     
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
                                <h3>Tax Information</h3>
                               <div>
                                <h:dataTable id="yearlyW2B" value="#{UserInfo.w2Models}" var="w2"
                                             rowClasses="list-row-odd, list-row-even" headerClass="table-header"
                                             styleClass="bordered">
                                    <h:column id="col_name">
                                        <h:commandButton value="#{w2.year}" action="#{w2.onClick}" styleClass="LinkButton"/>
                                    </h:column>
                                </h:dataTable>
                                </div>
                                
                                
                            </li>
                             
                            <li>
                                <h3>Human Resources</h3>
                                <div>
                                    <h:commandButton value="Vacation Days" styleClass="LinkButton"/>
                                     
                                    <br></br>
                                     
                                    <h:commandButton value="Payroll" styleClass="LinkButton"/>
                                     
                                    <br></br>
                                     
                                    <h:commandButton value="Reports" styleClass="LinkButton"/>
                                     
                                    <br></br>
                                </div>
                            </li>
                             
                            <li>
                                <h3>Alerts</h3>
                                <div><p style="color:red">No Alerts</p></div>
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p class="back">
                            <h:commandButton value="Logout" action="#{UserInfo.logOut}" styleClass="LinkButton"></h:commandButton>
                        </p>
                    </div>
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