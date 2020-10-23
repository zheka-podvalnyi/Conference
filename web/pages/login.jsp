<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<%--
  Created by IntelliJ IDEA.
  User: Zhekan
  Date: 06.10.2020
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jspf/head.jspf" %>

    <title>Login</title>
    <link rel="stylesheet" href="style.css">
</head>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: sans-serif;
        background: #34495e;
    }


    .form-control {
        height: 40px;
        box-shadow: none;
        color: #969fa4;
    }

    .form-control:focus {
        border-color: dodgerblue;
    }

    .form-control, .btn {
        border-radius: 3px;
    }

    .box {
        width: 300px;
        padding: 40px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background: yellowgreen;
        text-align: center;
    }



</style>
<body>

<form class="box" action="${pageContext.request.contextPath}/controller1" method="post">

    <input type="hidden" name="command" value="login">


    <c:if test="${not empty param.error}">

        <div>
            <label class="text-danger">${param.error}</label>
        </div>
    </c:if>
    <div class="form-group">
        <div class="input-group flex-nowrap">
            <div class="input-group-prepend">


        <input id="login" placeholder=
        <fmt:message bundle="${message}" key="global.username"/> type="text"
               class="form-control"
               name="login"
               aria-describedby="addon-wrapping" value="" required
               autofocus pattern="^(?!.*__.*)(?!.*\.\..*)[a-z0-9_.]{3,15}$">
    </div>
    </div>
    </div>


            <div class="form-group">
                <div class="input-group flex-nowrap">
                    <div class="input-group-prepend">


    <input id="password" placeholder=
    <fmt:message bundle="${message}"
                 key="global.password"/> aria-describedby="addon-wrapping2"
           type="password"
           class="form-control" name="password" required
           data-eye pattern="([\S]){6,32}">
                </div>
            </div>
            </div>


<div class="form-group list-inline">
    <div class="custom-control custom-switch">
        <input type="checkbox" class="custom-control-input list-inline-item" id="remember">
        <label class="custom-control-label list-inline-item" for="remember"><fmt:message
                bundle="${message}" key="login.remeber_me"/></label>
        <a href="${pageContext.request.contextPath}/controller1?command=changePassword"
           class="list-inline-item float-right">
            <fmt:message bundle="${message}" key="login.forgot_password"/>
        </a>
    </div>
</div>


<div class="form-group no-margin">
    <button type="submit" class="btn btn-primary btn-block">
        <fmt:message bundle="${message}" key="login.button_login"/>
    </button>
</div>
<div class="margin-top20 text-center">
    <fmt:message bundle="${message}" key="login.new_account"/> <a
        href="${pageContext.request.contextPath}/pages/registration.jsp">
    <fmt:message
            bundle="${message}" key="login.create_account"/></a>
</div>

</form>

</body>
</html>

