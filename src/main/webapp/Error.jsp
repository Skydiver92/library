<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Error</h1>
<h2><c:out value='${exception}'/><br/></h2>
</body>
</html>