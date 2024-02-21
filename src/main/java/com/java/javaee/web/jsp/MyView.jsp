<%@ page import="com.java.javaee.jsp.Student" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=((Student)request.getAttribute("Student")).getName()%>
<jsp:useBean id="Student" class="com.java.javaee.jsp.Student" scope="request"/>
<jsp:useBean id="Student" class="com.java.javaee.jsp.Student" scope="session"/>
<jsp:useBean id="Student" class="com.java.javaee.jsp.Student" scope="application"/>
<jsp:getProperty name="Student" property="name"/>
</body>
</html>