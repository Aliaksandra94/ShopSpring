<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<style>
    .round {
        border-radius: 100px; /* Радиус скругления */
        border: 3px #666; /* Параметры рамки */
        box-shadow: 0 0 7px #666; /* Параметры тени */
        margin: 6px;
    }

    .icon {
        margin: 6px;
    }
</style>
<head>
    <title><spring:message code="app.label.usersList"/></title>
    <link href="/images/other.css" rel="stylesheet" type="text/css">
    <p align="right"><a title="English" href="?lang=en"><img src="/images/UK.jpg" width="30px" height="30px"
                                                             class="round"></a>
        <a title="Russian" href="?lang=ru"><img src="/images/RU.png" width="30px" height="30px" class="round"></a></p>
</head>
<body>
<h2 align="center"><spring:message code="app.label.usersList"/></h2>
<table border="1" cellpadding="10" bgcolor="#fffacd" align="center">
    <tr>
        <th>№</th>
        <th><spring:message code="app.label.userName"/></th>
        <th><spring:message code="app.label.userLogin"/></th>
        <th><spring:message code="app.label.userPass"/></th>
        <th><spring:message code="app.label.userAge"/></th>
        <th><spring:message code="app.label.userRole"/></th>
        <th><spring:message code="app.label.userEmail"/></th>
        <th><spring:message code="app.label.userDiscount"/></th>
        <th><spring:message code="app.label.userAction"/></th>
    </tr>
    <c:forEach var="user" items="${usersList}">
        <tr>
            <td>${user.userID}</td>
            <td>${user.name}</td>
            <td>${user.login}</td>
            <td>${user.pass}</td>
            <td>${user.age}</td>
            <td>${user.role.name}</td>
            <td>${user.email}</td>
            <td>${user.discount}</td>
            <td>
                <a title="Edit" href="/user/edit/${user.userID}"><img
                        src="/images/edit.png" width="30px" height="30px"
                        class="icon"></a>
                <a title="Delete" href="/user/delete/${user.userID}"><img
                        src="/images/delete.png" width="30px" height="30px"
                        class="icon"></a>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br>
<c:url value="/user/add" var="add"/>
<p align="center"><a href="${add}"><spring:message code="app.label.addNewUser"/></a></p>
</body>
</html>