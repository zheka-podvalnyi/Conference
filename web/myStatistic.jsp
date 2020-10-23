<%--
  Created by IntelliJ IDEA.
  User: Zhekan
  Date: 19.10.2020
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jspf/head.jspf" %>


<%@ include file="/WEB-INF/jspf/navbar.jspf" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>


    button[id="operation"] {
        margin-right: 5px;
        width: 120px;
        height: 60px;
    }

    button[id="sort"] {
        margin-right: 10px;
    }




    body {
        background: #63738a;
    }



    .container-fluid .btn {
        font-size: 16px;
        font-weight: bold;
        outline: none !important;
    }

    legend {
        margin-left: 15px;
    }
    btn {
        color: yellowgreen;
        margin-left: 15px;
    }


</style>

<c:choose>
<c:when test="${sessionScope.user.permission=='Moderator'}">
<div class="container justify-content-center">
    <div class="body">



            <h2 class="display-4 text-danger"><fmt:message bundle="${message}" key="event.event_statistic"/></h2>

            <div class="form-group">

    <th scope="col">${requestScope.count}</th>

                <h1>Не прийшли</h1>
    <table class="table table-bordered">

        <tr>
            <th scope="col">event.id</th>
            <th scope="col">user.id</th>
        </tr>

    <c:forEach var="item" items="${requestScope.statistics}">

        <c:if test = "${not item.userStatus}">
            <tr>

                <th scope="col">${item.eventId}</th>
                <th scope="col">${item.userId}</th>


            </tr>
        </c:if>

    </c:forEach>
    </table>
    <h1>Прийшли</h1>
    <table class="table table-bordered">
        <tr>
            <th scope="col">event.id</th>
            <th scope="col">user.id</th>
        </tr>
    <c:forEach var="item" items="${requestScope.statistics}">


        <c:if test = "${item.userStatus}">
            <tr>
            <th scope="col">${item.eventId}</th>
            <th scope="col">${item.userId}</th>

            </tr>
        </c:if>



    </c:forEach>
        </table>
          <%--    <th scope="col"><a class="text-warning" type="submit" href="${pageContext.request.contextPath}/controller1?command=editEventForm&id=${item.id}"><fmt:message bundle="${message}"
                                                                                                                                                                        key="event.event_edit"/></a></th>
                              <th scope="col"><a class="text-info" type="submit" href="${pageContext.request.contextPath}/controller1?command=getStatistic&id=${item.id}"><fmt:message bundle="${message}"
                                                                                                                                                                                         key="event.event_statistic"/></a> </th>
--%>
                            </c:when>
    </c:choose>


            </div>

    </div>
</div>


