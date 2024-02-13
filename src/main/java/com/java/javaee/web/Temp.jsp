<%@ page import="java.util.Date" %>
<%@ page import="com.java.javaee.jsp.JSPHelper" %>
<html>
<head>
    <title>
        Title
    </title>
</head>
<body>
hello world
<%! int i = 5;%>
<%! private void doJob(){
    System.out.println("hello");
};%>
<%= "hello world"%>
<%= i+1+2%>
<%=new Date()%>
<%=JSPHelper.minus(5,3)%>
<%
    class Student {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
%>
<%= new Student().getName()%>

<% if (Math.random() > 5) {%>
   <b>hello world</b>
<%}%>

</body>
</html>