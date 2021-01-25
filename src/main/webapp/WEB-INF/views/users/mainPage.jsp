<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    .round {
        border-radius: 100px; /* Радиус скругления */
        border: 3px #666; /* Параметры рамки */
        box-shadow: 0 0 7px #666; /* Параметры тени */
        margin: 6px;
    }
    * {
        margin: 0;
        box-sizing: border-box;
    }
    .post-wrap {
        max-width: 1120px;
        margin: 0 auto;
        display: flex;
        justify-content: center;
        flex-wrap: wrap;
    }
    .post-item {
        padding: 15px;
        cursor: pointer;
    }
    .post-item * {
        transition: .3s linear;
    }
    .item-content {
        background: linear-gradient(177deg, #72998f, #c3eae2, #ecbfa8, #f6e5b1);;
        padding: 40px;
    }
    .item-icon {
        margin-bottom: 20px;
    }
    .item-icon:before {
        content: "";
        font-family: FontAwesome;
        color: #F09EA3;
        font-size: 50px;
        line-height: 1;
    }
    .item-icon.photo:before {
        content: "\f030";
    }
    .item-icon.video:before {
        content: "\f03d";
    }
    .item-icon.gift:before {
        content: "\f06b";
    }
    .item-icon.group:before {
        content: "\f0c0";
    }
    .item-icon.tree:before {
        content: "\f1bb";
    }
    .item-icon.anchor:before {
        content: "\f13d";
    }
    .post-item:hover .item-icon, .post-item:hover .item-body h3, .post-item:hover .item-body p {
        transform: translateY(-8px);
    }
    .item-body {
        color: #144864;
        font-size: 14px;
    }
    .item-body h3 {
        font-weight: 500;
        margin-bottom: 15px;
        transition-delay: .05s;
    }
    .item-body p {
        transition-delay: .1s;
    }
    .item-footer {
        padding-top: 15px;
    }
    .link {
        text-decoration: none;
        display: inline-block;
        overflow: hidden;
        position: relative;
        padding-right: 30px;
        font-size: 12px;
        text-transform: uppercase;
        font-weight: 600;
        color: #9b5a5e;
    }
    .link:before {
        content: "";
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        bottom: 0;
        height: .125rem;
        margin: auto;
        background: #9b5a5e;
        transform: scaleX(.2);
        transform-origin: left center;
        z-index: 0;
        transition: .6s cubic-bezier(.6, .01, 0, 1);
    }
    .link span {
        display: inline-block;
        position: relative;
        transform: translateX(-200%);
        transition: .6s cubic-bezier(.6, .01, 0, 1);
    }
    .post-item:hover .link span {
        transform: translateX(0%);
    }
    .post-item:hover .link:before {
        transform-origin: right center;
    }
    @media (min-width: 768px) {
        .post-item {
            flex-basis: 50%;
            flex-shrink: 0;
        }
    }
    @media (min-width: 960px) {
        .post-item {
            flex-basis: 33.333333333%;
        }
    }
</style>
<head>
    <link href="/images/other.css" rel="stylesheet" type="text/css">
    <p align="right"><a title="English" href="?lang=en"><img src="/images/UK.jpg" width="30px" height="30px"
                                                             class="round"></a>
        <a title="Russian" href="?lang=ru"><img src="/images/RU.png" width="30px" height="30px" class="round"></a></p>
    <title><spring:message code="mainPage.title"/></title>

    <h2><spring:message code="mainPage.hello"/>, ${user.name}!</h2>
</head>
<body>
<div class="post-wrap">
    <div class="post-item">
        <div class="item-content">
                <img src="/images/account.png" width="70px" height="70px">
            <div class="item-body">
                <h3><spring:message code="mainPage.personalAccountPage"/></h3>
                <p><spring:message code="mainPage.personalAccountPageMessage"/></p>
            </div>
            <div class="item-footer">
                <a href="/user/edit/${user.userID}" class="link"><span><spring:message code="mainPage.goTo"/></span></a>
            </div>
        </div>
    </div>

    <div class="post-item">
        <div class="item-content">
            <img src="/images/catalog.png" width="70px" height="70px">
            <div class="item-body">
                <h3><spring:message code="mainPage.catalog"/></h3>
                <p><spring:message code="mainPage.catalogMessage"/></p>
            </div>
            <div class="item-footer">
                <a href="/product/" class="link"><span><spring:message code="mainPage.goTo"/></span></a>
            </div>
        </div>
    </div>

    <div class="post-item">
        <div class="item-content">
            <img src="/images/cart.png" width="70px" height="70px">
            <div class="item-body">
                <h3><spring:message code="mainPage.basket"/></h3>
                <p><spring:message code="mainPage.basketMessage"/></p>
            </div>
            <div class="item-footer">
                <a href="" class="link"><span><spring:message code="mainPage.goTo"/></span></a>
            </div>
        </div>
    </div>

    <div class="post-item">
        <div class="item-content">
            <img src="/images/order.png" width="70px" height="70px">
            <div class="item-body">
                <h3><spring:message code="mainPage.orderHistory"/></h3>
                <p><spring:message code="mainPage.orderHistoryMessage"/></p>
            </div>
            <div class="item-footer">
                <a href="" class="link"><span><spring:message code="mainPage.goTo"/></span></a>
            </div>
        </div>
    </div>

    <div class="post-item">
        <div class="item-content">
            <img src="/images/exit.png" width="70px" height="70px">
            <div class="item-body">
                <h3><spring:message code="mainPage.exit"/></h3>
                <p><spring:message code="mainPage.exitMessage"/></p>
            </div>
            <div class="item-footer">
                <a href="/" class="link"><span><spring:message code="mainPage.goTo"/></span></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>