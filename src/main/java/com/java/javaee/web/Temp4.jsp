<%@ page import="com.java.javaee.jsp.Person" %>
<html>
<head>
    <title>
        Title
    </title>
</head>
<body>
<jsp:useBean id="person" class="com.java.javaee.jsp.Person" scope="request"/>
<jsp:useBean id="person" class="com.java.javaee.jsp.Person" scope="session"/>
<jsp:useBean id="person" class="com.java.javaee.jsp.Person" scope="application"/>
<jsp:useBean id="person" class="com.java.javaee.jsp.Person" scope="page"/>


<jsp:useBean id="person" class="com.java.javaee.jsp.Person" type="java.lang.Runnable"/>
<jsp:useBean id="person" class="com.java.javaee.jsp.Person" scope="session"/>
<jsp:setProperty name="person" property="name" value="Mike"/>

<%Person person1 = new Person();%>
<%! String name = "Max";%>
<jsp:setProperty name="person" property="name" value="name"/>
<jsp:setProperty name="person" property="name" value="<%=request.getParameter("name")%>"/>
<jsp:setProperty name="person" property="*"/>
<% person.setName("max");%>
<jsp:getProperty name="person" property="name"/>
<jsp:getProperty name="person" property="age"/>
<%= person.getName()%>
</body>
</html>