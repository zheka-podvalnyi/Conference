
<%--
  Created by IntelliJ IDEA.
  User: Zhekan
  Date: 17.10.2020
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<!doctype html>
<html lang="en">
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
<html>

<link href="${pageContext.request.contextPath}//maxcdn.bootstrapcdn.com/bootstrap/3.5.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<head>
    <title>Moderator Registration</title>
  <%--  <%@ include file="/WEB-INF/jspf/head.jspf" %>--%>
</head>

<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel='stylesheet' href='webjars/bootstrap/4.5.0/css/bootstrap.min.css'>

<style>
    .register{
        background: -webkit-linear-gradient(left, #3931af, #00c6ff);
        margin-top: 3%;
        padding: 3%;
    }
    .register-left{
        text-align: center;
        color: #fff;
        margin-top: 4%;
    }
    .register-left input{
        border: none;
        border-radius: 1.5rem;
        padding: 2%;
        width: 60%;
        background: #f8f9fa;
        font-weight: bold;
        color: #383d41;
        margin-top: 30%;
        margin-bottom: 3%;
        cursor: pointer;
    }
    .register-right{
        background: #f8f9fa;
        border-top-left-radius: 10% 50%;
        border-bottom-left-radius: 10% 50%;
    }
    .register-left img{
        margin-top: 15%;
        margin-bottom: 5%;
        width: 25%;
        -webkit-animation: mover 2s infinite  alternate;
        animation: mover 1s infinite  alternate;
    }
    @-webkit-keyframes mover {
        0% { transform: translateY(0); }
        100% { transform: translateY(-20px); }
    }
    @keyframes mover {
        0% { transform: translateY(0); }
        100% { transform: translateY(-20px); }
    }
    .register-left p{
        font-weight: lighter;
        padding: 12%;
        margin-top: -9%;
    }
    .register .register-form{
        padding: 10%;
        margin-top: 10%;
    }
    .btnRegister{
        float: right;
        margin-top: 10%;
        border: none;
        border-radius: 1.5rem;
        padding: 2%;
        background: #0062cc;
        color: #fff;
        font-weight: 600;
        width: 50%;
        cursor: pointer;
    }
    .register .nav-tabs{
        margin-top: 3%;
        border: none;
        background: #0062cc;
        border-radius: 1.5rem;
        width: 28%;
        float: right;
    }
    .register .nav-tabs .nav-link{
        padding: 2%;
        height: 34px;
        font-weight: 600;
        color: #fff;
        border-top-right-radius: 1.5rem;
        border-bottom-right-radius: 1.5rem;
    }
    .register .nav-tabs .nav-link:hover{
        border: none;
    }
    .register .nav-tabs .nav-link.active{
        width: 100px;
        color: #0062cc;
        border: 2px solid #0062cc;
        border-top-left-radius: 1.5rem;
        border-bottom-left-radius: 1.5rem;
    }
    .register-heading{
        text-align: center;
        margin-top: 8%;
        margin-bottom: -15%;
        color: #495057;
    }
</style>
<body>
<h1>Registration Form</h1>

<div class="dropdown-menu">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
        <fmt:message bundle="${message}" key="global.language"/>
    </button>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <button type="submit" form="changeLanguageRu" class="dropdown-item">Russian</button>
        <button type="submit" form="changeLanguageEn" class="dropdown-item">English</button>
    </div>
</div>
<form id="changeLanguageRu" action="${pageContext.request.contextPath}/controller1" method="post">
    <input type="hidden" name="command" value="changeLanguage">
    <input type="hidden" name="lang" value="ru">

</form>
<form id="changeLanguageEn" action="${pageContext.request.contextPath}/controller1" method="post">
    <input type="hidden" name="command" value="changeLanguage">
    <input type="hidden" name="lang" value="en">

</form>


<div>

    <div class="signup-form">
    <div class="container register">
        <div class="row">
            <div class="col-md-3 register-left">
                <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                <h3>Welcome</h3>
            </div>

            <form accept-charset="UTF-8" action="${pageContext.request.contextPath}/controller1" method="post">
                <input type="hidden" name="command" value="newModer">

                <h2><fmt:message bundle="${message}"
                                 key="register.register"/></h2>
                <p class="hint-text"><fmt:message bundle="${message}" key="register.texthelp_1"/></p>
                <c:if test="${not empty param.error}">
                <div>
                    <label class="text-danger">${param.error}</label>
                </div>
                </c:if>
                <div class="row register-form">
                    <div class="col-md-6">
                        <div class="form-inline form-group">
                            <div>
                                <input type="text" class="form-control" name="name"
                                       placeholder="<fmt:message bundle="${message}" key="global.name"/>"
                                       required="required" pattern="(\p{Lu}){1}(\p{Ll}{1,15})">
                                <label class="text-muted"><fmt:message bundle="${message}" key="register.example"/> Zheka</label>
                            </div>
                            <div>
                                <input type="text" class="form-control" name="middleName"
                                       placeholder="<fmt:message bundle="${message}" key="global.middlename"/>"
                                       required="required" pattern="(\p{Lu}){1}(\p{Ll}{1,15})">
                                <label class="text-muted"><fmt:message bundle="${message}" key="register.example"/>
                                    Sergeevich</label>
                            </div>
                            <div>
                                <input type="text" class="form-control" name="lastName"
                                       placeholder="<fmt:message bundle="${message}" key="global.lastname"/>"
                                       required="required" pattern="(\p{Lu}){1}(\p{Ll}{1,15})">
                                <label class="text-muted"><fmt:message bundle="${message}" key="register.example"/>
                                    Zhekan</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="mail"
                                   placeholder="<fmt:message bundle="${message}" key="global.mail"/>" required="required"
                                   pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$">
                            <label class="text-muted"><fmt:message bundle="${message}" key="register.example"/>
                                example@example.com</label>
                        </div>

                        <div class="form-group">
                            <input placeholder="<fmt:message bundle="${message}" key="register.date_of_birth"/>"
                                   class="form-control" name="birthday" type="date"
                                   onfocus="(this.type='date')"
                                   id="date"
                                   required="required">
                            <label class="text-muted"><fmt:message bundle="${message}" key="register.years_help"/></label>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="login"
                                   placeholder="<fmt:message bundle="${message}" key="global.username"/>" required="required"
                                   pattern="^(?!.*__.*)(?!.*\.\..*)[a-z0-9_.]{3,15}$">
                            <label class="text-muted"><fmt:message bundle="${message}" key="register.example"/> username1
                                <fmt:message bundle="${message}" key="register.login_help"/></label>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="password" id="password"
                                   placeholder="<fmt:message bundle="${message}" key="global.password"/>" required="required"
                                   pattern="([\S]){6,32}">
                            <label class="text-muted"><fmt:message bundle="${message}" key="register.password_help"/></label>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="confirm_password" id="confirm_password"
                                   placeholder="<fmt:message bundle="${message}" key="global.confirm_password"/>"
                                   required="required">
                            <label class="text-muted"><fmt:message bundle="${message}"
                                                                   key="register.confirm_password_help"/></label>
                        </div>

                        <div class="form-group">
                            <label class="checkbox-inline"><input type="checkbox" required="required"> <fmt:message
                                    bundle="${message}" key="register.i_accept_the"/> <a href="#">
                                <fmt:message bundle="${message}" key="register.terms_of_use"/>
                            </a> &amp; <a href="#"><fmt:message bundle="${message}" key="register.privacy_policy"/></a></label>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-lg btn-block"><fmt:message bundle="${message}"
                                                                                                        key="register.register_now"/></button>
                        </div>
                        <div class="form-group">
                            <div class="text-center"><fmt:message bundle="${message}" key="register.texthelp_2"/> <a
                                    href="${pageContext.request.contextPath}/login.jsp"><fmt:message bundle="${message}" key="login.button_login"/></a></div>
                        </div>
                    </div>
                </div>
                </div>
        </div>

    </div>
</div>

<script>


    var password = document.getElementById("password")
        , confirm_password = document.getElementById("confirm_password");

    function validatePassword() {
        if (password.value != confirm_password.value) {
            confirm_password.setCustomValidity("Passwords Don't Match");
        } else {
            confirm_password.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    confirm_password.onkeyup = validatePassword;
</script>


<script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</body>

</html>