<%@ page import="com.eaxmple.Student" %><%--
  Created by IntelliJ IDEA.
  User: tamojeetpal
  Date: 08/09/25
  Time: 3:48 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
</head>
<body>
<%
    Student s = (Student) request.getAttribute("student");
    out.println("Saved student is "+s.getFirstName()+" "+s.getLastName()+" "+s.getEmail());
%>
</body>
</html>
