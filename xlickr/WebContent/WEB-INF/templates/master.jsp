<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title><tiles:insertAttribute name="title"/></title>
<tiles:insertAttribute name="header"/>
</head>
<body ng-app="xlickr">
<tiles:insertAttribute name="navbar"/>

<tiles:insertAttribute name="body"/>


<tiles:insertAttribute name="footer"/>
</body>
</html>