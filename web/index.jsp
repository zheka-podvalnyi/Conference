<%--
  Created by IntelliJ IDEA.
  User: Zhekan
  Date: 01.10.2020
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date , java.text.SimpleDateFormat" %>
<%!
    String getFormattedDate()
    {
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        return date.format(new Date());
    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добро пожаловать, JSP!</title>
</head>
<body>
<h1>Добро пожаловать!</h1>
<i>Сегодня <%= getFormattedDate() %></i>
</body>
</html>