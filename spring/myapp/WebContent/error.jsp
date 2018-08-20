<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isErrorPage="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setAttribute("pageTitle", "Error"); %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${pageTitle}</title>
</head>
<body>
	<h1>${pageTitle}</h1>
	<br>
	<p>An error occured:</p>
	<b>Stack trace:</b>
	<pre>
		<% //exception.printStackTrace(response.getWriter()); %>
	</pre>
</body>
</html>