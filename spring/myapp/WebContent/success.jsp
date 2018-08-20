<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="error.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setAttribute("pageTitle", "Email Successfully Sent."); %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>${pageTitle}</title>
</head>
<body>    
    <h1>Success</h1>
    <br>
    <p>Hi ${param.userName}, your OS is ${param.os}, thanks for giving the details.</p>
    <p>Your unique password has been sent to you on <b>${param.emailID}</b></p>
    
</body>
</html>