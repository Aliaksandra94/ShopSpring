<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<style>
    .round {
        border-radius: 100px; /* Радиус скругления */
        border: 3px #666; /* Параметры рамки */
        box-shadow: 0 0 7px #666; /* Параметры тени */
        margin: 6px;
    }

    .link {
        display: inline-block;
        text-decoration: none;
        letter-spacing: 1px;
        margin: 5px 5px;
        padding: 25px 25px;
        font-size: 20px;
        font-weight: bold;
        font-family: "Gabriola", sans-serif;
        transition: 0.4s ease-in-out;
        color: #0e221c;
        border-radius: 10px;
        border: 3px solid #0e221c;
        background: #399283;
    }

    .link:hover {
        color: #73f1d1;
        background: #0e3c34;
    }

    .link span {
        opacity: 0;
        padding-left: 5px;
        padding-right: 5px;
        font-weight: bold;
        transition: 0.4s ease-in-out;
    }

    .link:hover span {
        opacity: 1;
        padding-left: 10px;
        padding-right: 10px;
        color: #BDB9AB;
    }
</style>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="/images/style.css" rel="stylesheet" type="text/css">
    <p align="right"><a title="English" href="?lang=en"><img src="/images/UK.jpg" width="30px" height="30px"
                                                             class="round"></a>
        <a title="Russian" href="?lang=ru"><img src="/images/RU.png" width="30px" height="30px" class="round"></a></p>
    <title><spring:message code="app.title.start"/></title>
</head>
<body>
<h2 align="center"><spring:message code="app.label.greeting"/></h2>
    <p align="center">
        <a href="/user/login" class="link"><spring:message code="app.label.loginPage"/> </a></p>
<p align="center">
    <a href="/product/" class="link"><spring:message code="app.label.continuePage"/></a></p>
<p align="center">
    <a href="/user/add" class="link"><spring:message code="app.label.registrationPage"/></a></p>
</body>
</html>