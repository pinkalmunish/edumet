<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/edumet.css" media="screen"/>
        <script type="text/javascript" src="scripts/accordion.js"></script>
    </head>
    <body bgcolor="#E0FFFF">
        <f:view>
            <h:form id="employeeDashBoard">
                <div id="mainContainer">
                    <h3 align="center">Sayreville School District Employee Portal</h3>
                     
                    <dl class="accordion" id="slider">
                        <dt> Alerts </dt>
                        <dd> No Alerts at this time </dd>
                        <dt> My Information </dt>
                        <dd>
                            <b>First Name:</b> Pinkal <br>
                            <b>Last Name:</b>  Shah <br>
                            <b>Employee State Id:</b> 123456 <br>
                            <b>Telephone:</b> 732 123 3456 <br>
                            <b>Salary:</b> $50,000/Year <br>
                            <b>Street:</b> 36 Lantern Lane <br>
                            <b>City:</b> Parlin <br> 
                            <b>State:</b> NJ <br>
                            <b>zip:</b> 08872 <br>
                        
                        </dd>
                        <dt>Tax Information</dt>
                        <dd>
                            <h:commandLink value="2009 W2"/>
                            <br></br>
                            <h:commandLink value="2010 W2"/>
                            <br></br>
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
                    </dl>
                </div>
                <p class="back">
                    <h:commandLink value="Logout" action="loginMain.jsp"></h:commandLink>
                </p>
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