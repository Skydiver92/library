<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome</h1>
    <br/>
    <form actiom="/" method="POST">
        <input type="text" name="name">
        <input type="submit" value="Submit">
    </form>
    <br/>
    <%
        Object name = session.getAttribute("user");
    %>
    <h1>User: <%=name%></h1>
</body>
</html>