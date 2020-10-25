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


<div class="form-group">

    ${requestScope.userEvents}
    <form action="${pageContext.request.contextPath}/controller1">
        <div class="form-inline">
            <input type="hidden" name="command" value="allEvents">

            <%--      <form action="${pageContext.request.contextPath}/controller1">
                      <div class="form-inline">
                          <input type="hidden" name="command" value="allEvents">--%>
            <button id="sort" class="btn btn-success" type="submit"><fmt:message bundle="${message}"
                                                                                 key="sort.events"/></button>
            <select id="approv_status" name="sortBy" class="form-control">
                <option value="dateUp"><b><fmt:message bundle="${message}" key="sort.up_by_date"/></b>
                </option>
                <option value="dateDown"><b><fmt:message bundle="${message}" key="sort.down_by_date"/></b>
                </option>
                <option value="reportsUp"><b><fmt:message bundle="${message}" key="sort.up_by_reports"/></b></option>
                <option value="reportsDown"><b><fmt:message bundle="${message}" key="sort.down_by_reports"/></b>
                </option>
                <option value="usersUp"><b><fmt:message bundle="${message}" key="sort.up_by_users"/></b>
                </option>
                <option value="usersDown"><b><fmt:message bundle="${message}" key="sort.down_by__users"/></b>

            </select>
        </div>
    </form>


</div>


<div class="container justify-content-center">
    <div class="body">


        <table class="table table-bordered">
            <h2 class="display-4 text-danger"><fmt:message bundle="${message}" key="global.events"/></h2>


            <thead>
            <tr>
                <th scope="col">#</th>

                <th scope="col"><fmt:message bundle="${message}"
                                             key="global.name"/></th>
                <th scope="col"><fmt:message bundle="${message}"
                                             key="global.place"/></th>
                <th scope="col"><fmt:message bundle="${message}"
                                             key="global.date"/></th>
            </tr>
            </thead>


            <%--
                <c:forEach var="item" items="${requestScope.events}">
                <tr>
                <th scope="col">${item.id}</th>
                    <th scope="col">${item.name}</th>
                <th scope="col">${item.place}</th>
                <th scope="col">${item.date}</th>
                    </tr>
                </c:forEach>--%>


            <c:choose>
                <c:when test="${sessionScope.user.permission eq'User'}">
                    <c:forEach var="item" items="${requestScope.events}">
                        <tr>
                            <th scope="col">${item.id}</th>
                            <th scope="col">${item.name}</th>
                            <th scope="col">${item.place}</th>
                            <th scope="col">${item.date}</th>


                        <th scope="col"><a class="btn-outline-success" type="submit"
                                              href="${pageContext.request.contextPath}/controller1?command=joinToEvent&id=${item.id}"><fmt:message
                                bundle="${message}"
                                key="event.join"/></a></th>
                            <th scope="col"><a class="btn-outline-info" type="submit"
                                               href="${pageContext.request.contextPath}/controller1?command=registerToEventForm&eventId=${item.id}"><fmt:message
                                    bundle="${message}"
                                    key="event.joinAsSpeaker"/></a></th>
                        </tr>
                    </c:forEach>

                </c:when>

            </c:choose>


            <c:choose>
            <c:when test="${sessionScope.user.permission eq'Moderator'}">


                <c:forEach var="item" items="${requestScope.events}">
                    <tr>
                        <th scope="col">${item.id}</th>
                        <th scope="col">${item.name}</th>
                        <th scope="col">${item.place}</th>
                        <th scope="col">${item.date}</th>


                        <th scope="col"><a class="btn btn-warning" type="submit"
                                           href="${pageContext.request.contextPath}/controller1?command=editEventForm&id=${item.id}"><fmt:message
                                bundle="${message}" key="event.event_edit"/></a></th>
                        <th scope="col"><a class="btn btn-info" type="submit"
                                           href="${pageContext.request.contextPath}/controller1?command=getStatistic&id=${item.id}"><fmt:message
                                bundle="${message}"
                                key="event.event_statistic"/></a></th>
                    </tr>
                </c:forEach>
            </c:when>
                </c:choose>








                </table>


    </div>
</div>


