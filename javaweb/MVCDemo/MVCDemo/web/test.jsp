<%-- 
    Document   : test.jsp
    Created on : Sep 11, 2017, 12:00:36 PM
    Author     : soderayi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Test Page</title>
    </head>
    <body>
        <h1>Films</h1>
        <p>Favorite Film title: ${requestScope.film.title}</p>
        <c:forEach var="film" items="${ filmList }" varStatus="counter">
            <label><c:out value="${ counter.count }"/>. ${ film.title }</label><br />
        </c:forEach>
    </body>
</html>
