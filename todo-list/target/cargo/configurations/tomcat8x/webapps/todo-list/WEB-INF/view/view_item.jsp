<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="academy.learnprogramming.util.Mapping" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Item</title>
</head>
<body>
<div align="center">
    <table>
        <c:url var="itemsLink" value="${Mapping.ITEMS}" />
        <a href="${itemsLink}">Show Todo Items</a>
        <tr>
            <td><label>Id</label></td>
            <td>${todoItem.id}</td>
        </tr>
        <tr>
            <td><label>Title</label></td>
            <td>${todoItem.title}</td>
        </tr>
        <tr>
            <td><label>Deadline</label></td>
            <td>${todoItem.deadline}</td>
        </tr>
        <tr>
            <td><label>Details</label></td>
            <td>${todoItem.details}</td>
        </tr>
    </table>
</div>
</body>
</html>