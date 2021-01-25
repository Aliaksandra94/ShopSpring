<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style type="text/css">
    .error{
        color: darkred;
    }
    .round {
         border-radius: 100px; /* Радиус скругления */
         border: 3px #666; /* Параметры рамки */
         box-shadow: 0 0 7px #666; /* Параметры тени */
         margin: 6px;
     }
</style>
<head>
    <link href="/images/other.css" rel="stylesheet" type="text/css">
    <p align="right"><a title="English" href="?lang=en"><img src="/images/UK.jpg" width="30px" height="30px"
                                                             class="round"></a>
        <a title="Russian" href="?lang=ru"><img src="/images/RU.png" width="30px" height="30px" class="round"></a></p>
    <c:if test="${empty product.name}">
        <title><spring:message code="app.label.addProduct"/></title>
    </c:if>
    <c:if test="${!empty product.name}">
        <title><spring:message code="app.label.editProduct"/></title>
    </c:if>
</head>
<c:if test="${empty product.name}">
    <c:url value="/product/add" var="var"/>
</c:if>
<c:if test="${!empty product.name}">
    <c:url value="/product/edit" var="var"/>
</c:if>
<body>
<c:if test="${empty product.name}">
    <h2><spring:message code="app.label.addProduct"/></h2>
</c:if>
<c:if test="${!empty product.name}">
    <h2><spring:message code="app.label.editProduct"/></h2>
</c:if>
<form:form method="POST" action="${var}" modelAttribute="product">
    <form:label path="name"><spring:message code="app.label.productName"/></form:label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error" />
    <br><br>
    <form:label path="price"><spring:message code="app.label.productPrice"/></form:label>
    <form:input path="price"/>
    <form:errors path="price" cssClass="error" />
    <br><br>
    <form:label path="quantity"><spring:message code="app.label.productQuantity"/></form:label>
    <form:input path="quantity"/>
    <form:errors path="quantity" cssClass="error" />
    <br><br>
    <br><br>
    <c:if test="${!empty product.name}">
    <input type="hidden" name="productID" value="${product.productID}"/>
</c:if>
    <c:if test="${!empty product.name}">
        <spring:message code="app.label.addProduct" var="add"/>
        <input type="submit" value="${add}">
    </c:if>
    <c:if test="${empty product.name}">
        <spring:message code="app.label.saveEditProduct" var="edit"/>
        <input type="submit" value="${edit}">
    </c:if>
</form:form>
</body>
</html>
