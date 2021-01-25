<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<style>
    .round {
        border-radius: 100px; /* Радиус скругления */
        border: 3px #666; /* Параметры рамки */
        box-shadow: 0 0 7px #666; /* Параметры тени */
        margin: 6px;
    }
</style>
<head>
    <link href="/images/other.css.css" rel="stylesheet" type="text/css">
    <p align="right"><a title="English" href="?lang=en"><img src="/images/UK.jpg" width="30px" height="30px"
                                                             class="round"></a>
        <a title="Russian" href="?lang=ru"><img src="/images/RU.png" width="30px" height="30px" class="round"></a></p>
    <title><spring:message code="basket.title"/></title>
</head>
<body>
<table border="1" width="100%" cellpadding="5">
    <tr>
        <th width="25%"><spring:message code="basket.name"/></th>
        <th width="5%"><spring:message code="basket.price"/></th>
        <th width="5%"><spring:message code="basket.quantity"/></th>
        <th width="5%"><spring:message code="basket.total"/></th>
        <th width="20%"><spring:message code="basket.changeQuantity"/></th>
        <th width="5%"><spring:message code="basket.delete"/></th>
    </tr>
    <c:forEach items="${listOfProductsInBasket}" var="product">
        <tr>
            <td> ${product.products.get(0).name}
            </td>
            <td> ${product.products.get(0).price}
            </td>
            <td> ${product.quantity}
            </td>
            <td> ${product.products.get(0).price * product.quantity}
            </td>
            <td>
                <form action="/basket" method="POST">
                    <input type="hidden" name="_method" value="patch">
                    <input type="hidden" name="operationInBasket" value="modifyProduct">
                    <input name="count" value="${product.quantity}"/>
                    <input type="hidden" name="product_id" value="${product.products.get(0).id}"/>
                    <spring:message code="app.label.saveEditUser" var="edit"/>
                    <input type="submit" value=${edit}/>
                </form>
            </td>
            <td>
                <form action="/basket" method="POST">
                    <input type="hidden" name="_method" value="delete">
                    <input type="hidden" name="operationInBasket" value="deleteProduct">
                    <input type="hidden" name="idProduct" value="${product.products.get(0).id}"/>
                    <input type='submit' value='Удалить'/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</h2>
<h2 align="right">
    <form action='/makeOrder.jsp'>
        <input type="hidden" name="operationInBasket" value="pay">
        <input type='submit' value='Оформить заказ'/>
    </form>
</h2>
<p><a href="/shop/">В магазин</a></p>
<p><a href="">На главную страницу</a></p>
</body>
</html>