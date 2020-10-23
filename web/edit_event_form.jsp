

<%--
  Created by IntelliJ IDEA.
  User: Zhekan
  Date: 20.10.2020
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <html>
    <link href="${pageContext.request.contextPath}//maxcdn.bootstrapcdn.com/bootstrap/3.5.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


    <%@ include file="/WEB-INF/jspf/head.jspf" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

            <form class="form-horizontal">
                <fieldset>

                    <!-- Form Name -->
                    <legend>Event Form</legend>


                    <input type="hidden" value="${requestScope.id}" name="id">


                    <!-- Text input-->
                    <div class="form-group">

                        <label class="col-md-4 control-label" for="textinput"> <fmt:message bundle="${message}" key="global.name"/></label>
                        <div class="col-md-4">
                            <input id="textinput" name="name" type="name" value="${requestScope.event.name}" class="form-control input-md">

                        </div>



                        <label class="col-md-4 control-label" for="textinput"> <fmt:message bundle="${message}" key="global.date"/></label>
                        <div class="col-md-4">
                            <input id="textinput" name="date" type="text" value="${requestScope.event.date}" class="form-control input-md">

                        </div>
                    </div>


                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="textinput"> <fmt:message bundle="${message}" key="global.place"/></label>
                        <div class="col-md-4">
                            <input id="textinput" name="place" type="text" placeholder="${requestScope.event.place}" class="form-control input-md">

                        </div>
                    </div>



                    <input type="submit" class="btn btn-success" name="command" value="editEvent"/> <fmt:message bundle="${message}"
                                                                                         key="event.event_edit"/>


                    <input type="submit" class="btn btn-warning" name="command" value="deleteEvent"/> <fmt:message bundle="${message}"
                                                                                                                 key="event.delete_event"/>



              <%--  <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-lg btn-block"><fmt:message bundle="${message}"
                                                                                                key="event.event_edit"/></button>
                </div>--%>

            <%--  <form action="${pageContext.request.contextPath}/controller1" method="post">
             <input type="hidden" name="command" value="editEvent">--%>
            <%--<h2><fmt:message bundle="${message}" key="event.event_edit"/></h2>--%>


                   <%--     <input type="hidden" name="command" value="deleteEvent">
                        <input type="hidden" name="eventId" value="${item.id}">

                        <button type="submit" class="btn btn-danger"><fmt:message
                                bundle="${message}"
                                key="event.delete_event"/></button>--%>



        </div>

    </html>
