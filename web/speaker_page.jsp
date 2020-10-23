<%--
  Created by IntelliJ IDEA.
  User: Zhekan
  Date: 23.10.2020
  Time: 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jspf/head.jspf" %>


<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
<html>

<body>

<div class="form-group">

    <form action="${pageContext.request.contextPath}/controller1">
        <div class="form-inline">
            <input type="hidden" name="command" value="myEvents">

            <%--      <form action="${pageContext.request.contextPath}/controller1">
                      <div class="form-inline">
                          <input type="hidden" name="command" value="allEvents">--%>
            <button id="sort" class="btn btn-success" type="submit"><fmt:message bundle="${message}"
                                                                                 key="sort.events"/></button>
            <select id="approv_status" name="sortBy" class="form-control">
                <option value="DateUp"><b><fmt:message bundle="${message}" key="sort.up_by_date"/></b>
                </option>
                <option value="DateDown"><b><fmt:message bundle="${message}" key="sort.down_by_date"/></b>
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
</form>

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




                <c:forEach var="item" items="${requestScope.userEvents}">
                <tr>
                <th scope="col">${item.id}</th>
                    <th scope="col">${item.name}</th>
                <th scope="col">${item.place}</th>
                <th scope="col">${item.date}</th>
                    </tr>
                </c:forEach>


           <%-- <c:forEach var="item" items="${requestScope.userEvents}">
            <tr>
                <th scope="col">${item.id}</th>
                <th scope="col">${item.name}</th>
                <th scope="col">${item.place}</th>
                <th scope="col">${item.date}</th>
            </tr>--%>

            <div  type="button"><a  class="text-success" href="${pageContext.request.contextPath}/controller1?command=joinToEvent&id=${item.id}"><fmt:message bundle="${message}"
                                                                                                                                                              key="event.join"/></a> </div>
          <%--  </c:forEach>--%>





</body>
</html>
