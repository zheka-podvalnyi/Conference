<%--
  Created by IntelliJ IDEA.
  User: Zhekan
  Date: 18.10.2020
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="${pageContext.request.contextPath}//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style>
    body {
        background: #63738a;
    }

    .signup-form {
        width: 672px;
        margin: 0 auto;
        padding: 30px 0;
    }


    .form-control:focus {
        border-color: dodgerblue;
    }

    .form-control, .btn {
        border-radius: 3px;
    }


    .signup-form h2 {
        color: #636363;
        margin: 0 0 15px;
        position: relative;
        text-align: center;
    }

    .signup-form h2:before, .signup-form h2:after {
        content: "";
        height: 2px;
        width: 30%;
        background: #d4d4d4;
        position: absolute;
        top: 50%;
        z-index: 2;
    }

    .signup-form h2:before {
        left: 0;
    }

    .signup-form h2:after {
        right: 0;
    }

    .signup-form .hint-text {
        color: #999;
        margin-bottom: 30px;
        text-align: center;
    }

    .signup-form form {
        color: #999;
        border-radius: 3px;
        margin-bottom: 15px;
        background: #f2f3f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }

    .signup-form .form-group {
        margin-bottom: 20px;
    }

    .signup-form input[type="checkbox"] {
        margin-top: 3px;
    }

    .signup-form .btn {
        font-size: 16px;
        font-weight: bold;
        width: 200px;
        height: 40px;
        outline: none !important;
    }

    .signup-form .row div:first-child {
        padding-right: 10px;
    }

    .signup-form .row div:last-child {
        padding-left: 10px;
    }

    .signup-form a {
        color: #fff;
        text-decoration: underline;
    }

    .signup-form a:hover {
        text-decoration: none;
    }

    .signup-form form a {
        color: dodgerblue;
        text-decoration: none;
    }

    .signup-form form a:hover {
        text-decoration: underline;
    }

</style>

<div class="signup-form">
    <form action="${pageContext.request.contextPath}/controller1" method="post">
        <input type="hidden" name="command" value="addEvent">

<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Event Form</legend>

        <!-- Text input-->


        <label class="col-md-4 control-label" for="textinput"> <fmt:message bundle="${message}" key="global.name"/></label>
        <div class="form-group">
            <input id="textinput" name="name" type="text" value="${requestScope.event.name}" class="form-control input-md">

            </div>

        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textarea">Speaker</label>
            <div class="col-md-4">
                <textarea class="form-control" id="textarea" name="textarea"></textarea>
            </div>
        </div>


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput"> Date</label>
            <div class="col-md-4">
                <input id="textinput" name="textinput" type="date" placeholder="Start Date" class="form-control input-md">
                <span class="help-block">help</span>
            </div>
        </div>


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput"> Place</label>
            <div class="col-md-4">
                <input id="textinput" name="textinput" type="text" placeholder="Place" class="form-control input-md">
                <span class="help-block">help</span>
            </div>
        </div>


               <div class="form-group">
                   <input type="submit" name="command" value="addEvent"/> <fmt:message bundle="${message}"
                                                                                      key="userbar.create_event"/>
               </div>

    </fieldset>
</form


</html>
