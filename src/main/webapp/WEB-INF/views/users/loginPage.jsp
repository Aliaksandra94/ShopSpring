<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    .border {
        max-width: 500px;
        background-color: aliceblue;
        border-image-width: 50px;
        border-top-left-radius: 100% 40px;
        border-bottom-right-radius: 100% 30px;
        align-content: center;
        align-items: center;
        margin: 80px auto 0;
        padding: 20px;
        text-align: center;
        font-family: "Gabriola", Georgia, Serif;
        font-weight: 700;
        font-size: x-large;
        box-sizing: border-box;
        font-variant-ligatures: common-ligatures;
    }
    .button {
        border-radius: 10px 10px;
        background: antiquewhite;
        color: black;
        font-family: "Gabriola", Georgia, Serif;
        font-weight: 800;
        padding: 5px 5px;
        font-size: x-large;
    }
    .button:hover {
        color: #BDB9AB;
        background: #4e4848;
    }
    .button span {
        opacity: 0;
        padding-left: 5px;
        padding-right: 5px;
        font-weight: bold;
        transition: 0.4s ease-in-out;
    }
    .button:hover span {
        opacity: 1;
        padding-left: 10px;
        padding-right: 10px;
        color: #BDB9AB;
    }
    .link{
        display: inline-block;
        text-decoration: none;
        letter-spacing: 1px;
        margin: 25px 25px;
        padding: 3px 3px;
        font-size: large;
        font-weight: bold;
        font-family: "Gabriola", sans-serif;
        transition: 0.4s ease-in-out;
        color: black;
        border-radius: 25px;
        border: 3px solid #1c1b1b;
        background: antiquewhite;
    }
    .link:hover {
        color: antiquewhite;
        background: #4e4848;
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

    <link href="/images/other.css" rel="stylesheet" type="text/css">
    <p align="right"><a title="English" href="?lang=en"><img src="/images/UK.jpg" width="30px" height="30px"
                                                             class="round"></a>
        <a title="Russian" href="?lang=ru"><img src="/images/RU.png" width="30px" height="30px" class="round"></a></p>
</head>
<body>
<form:form method="POST" action="${var}" modelAttribute="user" cssClass="border">
    <br><br>
    <form:label path="login"><spring:message code="app.label.login"/></form:label>
    <form:input path="login"/>
    <form:errors path="login" cssClass="error"/>
    <br>
    <form:label path="pass"><spring:message code="app.label.pass"/></form:label>
    <form:input path="pass"/>
    <form:errors path="pass" cssClass="error"/>
    <br>
            <spring:message code="app.label.submit" var="login"/>
            <input type="submit" class="button" value="${login}">
    <br><br>
    <a href="/user/add" class="link"><spring:message code="app.label.registrationPage"/></a>
    <br><br>
</form:form>
</body>
</html>
