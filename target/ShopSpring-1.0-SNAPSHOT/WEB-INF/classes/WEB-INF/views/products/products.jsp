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
    .table_blur {
        background: #f5ffff;
        border-collapse: collapse;
        text-align: left;
    }
    .table_blur th {
        border-top: 1px solid #777777;
        border-bottom: 1px solid #777777;
        box-shadow: inset 0 1px 0 #999999, inset 0 -1px 0 #999999;
        background: linear-gradient(#9595b6, #b5abf8);
        color: white;
        padding: 10px 15px;
        position: relative;
    }
    .table_blur th:after {
        content: "";
        display: block;
        position: absolute;
        left: 0;
        top: 25%;
        height: 25%;
        width: 100%;
        background: linear-gradient(rgba(255, 255, 255, 0), rgba(255,255,255,.08));
    }
    .table_blur tr:nth-child(odd) {
        background: #ebf3f9;
    }
    .table_blur th:first-child {
        border-left: 1px solid #777777;
        border-bottom:  1px solid #777777;
        box-shadow: inset 1px 1px 0 #999999, inset 0 -1px 0 #999999;
    }
    .table_blur th:last-child {
        border-right: 1px solid #777777;
        border-bottom:  1px solid #777777;
        box-shadow: inset -1px 1px 0 #999999, inset 0 -1px 0 #999999;
    }
    .table_blur td {
        border: 1px solid #e3eef7;
        padding: 10px 15px;
        position: relative;
        transition: all 0.5s ease;
    }
    .table_blur tbody:hover td {
        color: transparent;
        text-shadow: 0 0 3px #a09f9d;
    }
    .table_blur tbody:hover tr:hover td {
        color: #444444;
        text-shadow: none;
    }
</style>
<head>
    <title><spring:message code="app.title.products"/></title>
    <link href="/images/other.css" rel="stylesheet" type="text/css">
    <p align="right"><a title="English" href="?lang=en"><img src="/images/UK.jpg" width="30px" height="30px"
                                                             class="round"></a>
        <a title="Russian" href="?lang=ru"><img src="/images/RU.png" width="30px" height="30px" class="round"></a></p>
</head>
<body>
<h2 align="center"><spring:message code="app.title.products"/></h2>
<table border="1" cellpadding="10" class="table_blur" align="center">
    <tr>
        <th>№</th>
        <th><spring:message code="app.label.productName"/></th>
        <th><spring:message code="app.label.productPrice"/></th>
        <th><spring:message code="app.label.productQuantity"/></th>
        <th><spring:message code="app.label.actionProduct"/></th>
    </tr>
    <c:forEach var="product" items="${productsList}">
        <tr>
            <td>${product.productID}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>
                <a title="edit" href="/product/edit/${product.productID}"><img src="/images/edit.png" width="30px" height="30px" class="icon"></a>
                <a title="delete" href="/product/delete/${product.productID}"><img src="/images/delete.png" width="30px" height="30px" class="icon"></a>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br>
<p align="center"><a href="/product/add"><spring:message code="app.label.addProduct"/></a></p>
</body>
</html>
