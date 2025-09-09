<%--
  Created by IntelliJ IDEA.
  User: tamojeetpal
  Date: 08/09/25
  Time: 1:07 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo</title>
</head>
<body>
<%
out.println("Hi guyz");
%>
<form action="dao" method="get">
    FirstName: <input type="text" name="f"><br />
    LastName: <input type="text" name="l"><br />
    Email: <input type="text" name="email"><br />
    <input type="submit" value="Submit">
</form>
</body>
</html>
