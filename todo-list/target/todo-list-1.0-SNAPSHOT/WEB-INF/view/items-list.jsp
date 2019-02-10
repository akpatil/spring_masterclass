<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="academy.learnprogramming.util.Mapping" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Items List</title>
</head>
<body>
<div align="center">
    <c:url var="addUrl" value="${Mapping.ADD_ITEM}" />
    <a href="${addUrl}">New Item</a>
    <table border=1>
        <tr>
            <th>Title</th>
            <th>Deadline</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="list" items="${todoItem.items}">
            <tr>
                <c:url var="editUrl" value="${Mapping.ADD_ITEM}">
                    <c:param name="id" value="${list.id}" />
                </c:url>
                <c:url var="deleteUrl" value="${Mapping.DELETE_ITEM}">
                    <c:param name="id" value="${list.id}" />
                </c:url>
                <c:url var="viewUrl" value="${Mapping.VIEW_ITEM}">
                    <c:param name="id" value="${list.id}" />
                </c:url>
                <td><a href="${viewUrl}"><c:out value="${list.title}" /></a></td>
                <td><c:out value="${list.deadline}" /></td>
                <td><a href="${editUrl}">Edit</a></td>
                <td><a href="${deleteUrl}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>