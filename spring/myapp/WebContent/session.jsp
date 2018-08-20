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
<%@ page import="java.io.*, java.util.*" %> 
<%
java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy");
request.setAttribute("year", sdf.format(new java.util.Date()));
request.setAttribute("tomcatUrl", "http://tomcat.apache.org/");
request.setAttribute("tomcatDocUrl", "/docs/");
request.setAttribute("tomcatExamplesUrl", "/examples/");
request.setAttribute("pageTitle", "Session");
%>

<%
   // creation time of session
   Date create = new Date(session.getCreationTime());
 
   String key = new String("visitCount");
   Integer visitCount = (Integer) session.getAttribute(key);

    if(session.isNew() || visitCount == null){
        visitCount = new Integer(0);
    }

   visitCount += 1;
   session.setAttribute(key, visitCount);

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
        <h1>${pageTitle}</h1>
        <table border="1">
<tr>
   <th>Session Information</th>
   <th>Value</th>
</tr>
<tr>
   <td>id</td>
   <td><% out.print(session.getId()); %></td>
</tr>
<tr>
   <td>Creation Time</td>
   <td><% out.print(create); %></td>
</tr>
 
<tr>
   <td>Number of visits</td>
   <td><% out.print(visitCount); %></td>
</tr>
</table>

        

    </div>
</body>

</html>
