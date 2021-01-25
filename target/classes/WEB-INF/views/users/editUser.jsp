<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    .error {
        color: maroon;
    }

    .round {
        border-radius: 100px; /* Радиус скругления */
        border: 3px #666; /* Параметры рамки */
        box-shadow: 0 0 7px #666; /* Параметры тени */
        margin: 6px;
    }

    .a {
        display: inline-block;
        text-decoration: none;
        letter-spacing: 1px;
        margin: 25px 25px;
        padding: 15px 30px;
        font-size: large;
        font-weight: bold;
        font-family: "Gabriola", sans-serif;
        transition: 0.4s ease-in-out;
        color: #B05151;
        border-radius: 10px;
        border: 3px solid #1c1b1b;
        background: #E8CCB5;
        position: relative;
        box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.3);
    }

    .a:before, .a:after {
        content: "";
        display: inline-block;
        position: absolute;
        top: calc(50% - 5px);
        width: 10px;
        height: 10px;
        border-radius: 50%;
        background: #F58262;
        box-shadow: inset 0 -2px 0 #B05151;
        opacity: 0;
        transition: .5s ease-in-out;
    }

    .a:before {
        left: 13px;
    }

    .a:after {
        right: 13px;
    }

    .a:hover:before, .a:hover:after {
        opacity: 1;
    }
</style>
<head>
    <link href="/images/other.css" rel="stylesheet" type="text/css">
    <p align="right"><a title="English" href="?lang=en"><img src="/images/UK.jpg" width="30px" height="30px"
                                                             class="round"></a>
        <a title="Russian" href="?lang=ru"><img src="/images/RU.png" width="30px" height="30px" class="round"></a></p>
    <c:if test="${empty user.page}">
        <title><spring:message code="app.label.registrationPage"/></title>
    </c:if>
    <c:if test="${!empty user.page}">
        <title><spring:message code="app.label.saveEditUser"/></title>
    </c:if>
</head>
<c:if test="${empty user.page}">
    <c:url value="/user/add" var="var"/>
</c:if>
<c:if test="${!empty user.page}">
    <c:url value="/user/edit" var="var"/>
</c:if>
<body>
<form:form method="POST" action="${var}" modelAttribute="user">
    <form:label path="name"><spring:message code="app.label.userName"/></form:label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error"/>
    <br><br>
    <form:label path="login"><spring:message code="app.label.userLogin"/></form:label>
    <form:input path="login"/>
    <form:errors path="login" cssClass="error"/>
    <br><br>
    <form:label path="pass"><spring:message code="app.label.userPass"/></form:label>
    <form:input path="pass"/>
    <form:errors path="pass" cssClass="error"/>
    <br><br>
    <form:label path="age"><spring:message code="app.label.userAge"/></form:label>
    <form:input path="age"/>
    <form:errors path="age" cssClass="error"/>
    <br><br>
    <form:label path="email"><spring:message code="app.label.userEmail"/></form:label>
    <form:input path="email"/>
    <form:errors path="email" cssClass="error"/>
    <br><br>
    <form:label path="discount"><spring:message code="app.label.userDiscount"/></form:label>
    <form:input path="discount"/>
    <form:errors path="discount" cssClass="error"/>
    <c:if test="${!empty user.name}">
        <br><br>
        <tr>
            <td><spring:message code="app.label.userRole"/>:</td>
            <td><form:select path="role">
                <form:option value="role" label="---Select---"/>
                <form:options items="${roles}"/>
            </form:select>
            </td>
        </tr>
    </c:if>
    <br><br>
    <c:if test="${!empty user.name}">
        <input type="hidden" name="userID" value="${user.userID}"/>
    </c:if>
    <br><br>
    <br><br>
    <c:if test="${!empty user.page}">
        <spring:message code="app.label.saveEditUser" var="edit"/>
        <input type="submit" value="${edit}" class="a">
    </c:if>
    <c:if test="${empty user.page}">
        <spring:message code="app.label.addUser" var="add"/>
        <input type="submit" value="${add}" class="a">
    </c:if>
</form:form>
</body>
</html>
