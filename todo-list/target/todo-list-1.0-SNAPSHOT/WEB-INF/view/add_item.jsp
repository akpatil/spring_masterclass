<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="academy.learnprogramming.util.AttributeNames" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Item</title>
</head>
<body>
<div align="center">
    <form:form method="POST" modelAttribute="${AttributeNames.TODO_ITEMS}">
        <table>
            <tr>
                <td><label>Id</label></td>
                <td>
                    <form:input path="id" disabled="true" />
                </td>
            </tr>
            <tr>
                <td><label>Title</label></td>
                <td>
                    <form:input path="title" />
                </td>
            </tr>
            <tr>
                <td><label>Deadline</label></td>
                <td>
                    <form:input path="deadline" />
                </td>
            </tr>
            <tr>
                <td><label>Details</label></td>
                <td>
                    <form:input path="details" />
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="submit" /></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>