<%-- 
    Document   : login.jsp
    Created on : Sep 8, 2017, 1:46:49 PM
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
        <h1>Login!</h1>
        <form action="login" method="post">
            Enter username : <input type="text" name="username" /> <br />
            Enter password : <input type="password" name="password"> <br />
            <input type="submit" value="Log in" />
        </form>
    </body>
</html>
