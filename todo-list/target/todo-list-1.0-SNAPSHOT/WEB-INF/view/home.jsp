<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="academy.learnprogramming.util.Mapping" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo List Application</title>
</head>
<body>
<div align="center">
    <c:url var="itemsLink" value="${Mapping.ITEMS}" />
    <h2><a href="${itemsLink}">Show Todo Items</a></h2>
</div>
</body>
</html>