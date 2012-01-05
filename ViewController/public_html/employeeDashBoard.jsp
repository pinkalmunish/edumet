<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/edumet.css" media="screen"/>
    </head>
    <body bgcolor="#E0FFFF">
        <f:view>
            <h:form id="employeeDashBoard">
                <div id="mainContainer">
                    <h3 align="center">Sayreville School District Employee Portal</h3>
                    <div align="left">
                        <h4 align="left">Tax Information</h4>
                    </div>
                    <div align="left">
                        <h:commandLink value="2009 W2"/>
                    </div>
                    <div align="left">
                        <h:commandLink value="2010 W2"/>
                    </div>
                    <div></div>
                    <div align="left">
                        <h4 align="left">Human Resources</h4>
                    </div>
                    <div align="left">
                        <h:commandLink value="Vacation Days"/>
                    </div>
                    <div align="left">
                        <h:commandLink value="Payroll"/>
                    </div>
                    <div align="left">
                        <h:commandLink value="Reports"/>
                    </div>
                    <p class="back">
                        <h:commandLink value="Logout" action="index.jsp"></h:commandLink>
                    </p>
                </div>
            </h:form>
        </f:view>
    </body>
</html>