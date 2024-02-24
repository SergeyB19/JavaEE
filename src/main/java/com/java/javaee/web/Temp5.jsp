<%@page isELIgnored="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${stud.name}
${stud.["name"]}
${requestScope.stud.name}
${sessionScope.stud.name}
${applicationScope.stud.name}


${list[1]}
${map["one"]}
${map.two}
${1+2*3/2}
${map.two==2}
${map.two>1}
${map.two!=1 ? "one" : "two"}
<jsp:setProperty name="stud" property="name" value="${Mr}.${Max}"/>
\${1,2,3}

${cookie.JSESSIONID}
${header}

</body>
</html>