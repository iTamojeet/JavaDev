<%--
  Created by IntelliJ IDEA.
  User: tamojeetpal
  Date: 08/09/25
  Time: 3:01 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Output</title>
</head>
<body>
<%
String name = (String) request.getAttribute("myname");
out.println("Welcome "+name);
%>
</body>
</html>
