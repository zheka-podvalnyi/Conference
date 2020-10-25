<%--
  Created by IntelliJ IDEA.
  User: Zhekan
  Date: 24.10.2020
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <form class="form-horizontal" action="${pageContext.request.contextPath}/controller1" method="post">
        <input type="hidden" name="command" value="joinToEventAsSpeaker">

                <input type="hidden" name="id" value="${requestScope.id}">
            <fieldset>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput"> <fmt:message bundle="${message}"
                                                                                        key="event.topic"/></label>
                    <div class="col-md-4">
                        <input id="textinput" name="topic" type="text" placeholder="Topic" class="form-control input-md">
                        <span class="help-block">help</span>
                    </div>
                </div>



                <div class="form-group">
                    <input type="submit" name="command" value="joinToEventAsSpeaker"> <fmt:message bundle="${message}"
                                                                                        key="event.joinAsSpeaker"/>
                </div>
            </fieldset>
        </form>

</div>