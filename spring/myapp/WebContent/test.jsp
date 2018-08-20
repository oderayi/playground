<%--
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
--%>
<!DOCTYPE html>
<%@ page session="true" %>
<%
java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy");
request.setAttribute("year", sdf.format(new java.util.Date()));
request.setAttribute("tomcatUrl", "http://tomcat.apache.org/");
request.setAttribute("tomcatDocUrl", "/docs/");
request.setAttribute("tomcatExamplesUrl", "/examples/");
%>
<html lang="en">
<head>
    <title><%=request.getServletContext().getServerInfo() %></title>
    <link href="assets/favicon.ico" rel="icon" type="image/x-icon" />
    <link href="assets/favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <link href="assets/tomcat.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <div id="wrapper">
        <h1>Fill the form given below:</h1>
        <form method="post" action="success.jsp?os=Windows">
        User : <input type="text" name="userName"><br>
        Email: <input type="email" name="emailID">
        <p><input type="submit" value="submit"></p>
        </form>

    </div>
</body>

</html>
