<%-- 
    Document   : success
    Created on : Sep 8, 2017, 1:46:59 PM
    Author     : soderayi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome!</h1>
        <p>Welcome ${ requestScope['user'].getUsername() }</p>
    </body>
</html>
