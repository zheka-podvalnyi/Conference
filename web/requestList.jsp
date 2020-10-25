<%--
  Created by IntelliJ IDEA.
  User: Zhekan
  Date: 25.10.2020
  Time: 2:33
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






<div class="container justify-content-center">
    <div class="body">


        <table class="table table-bordered">


            <c:choose>

                <c:when test="${sessionScope.user.permission eq'Moderator'}">

                    <c:forEach var="item" items="${requestScope.requestDtoList}">


                        <tr>
                            <th scope="col">${item.userId}</th>
                            <th scope="col">${item.userName}</th>
                            <th scope="col">${item.userMiddleName}</th>
                            <th scope="col">${item.userLastName}</th>
                            <th scope="col">${item.userLogin}</th>
                            <th scope="col">${item.eventId}</th>
                            <th scope="col">${item.eventDate}</th>
                            <th scope="col">${item.eventPlace}</th>
                            <th scope="col">${item.eventName}</th>
                            <th scope="col">${item.topic}</th>

                            <form method="post" action="${pageContext.request.contextPath}/controller1">
                                <input type="hidden" name="userId" value="${item.userId}">
                                <input type="hidden" name="eventId" value="${item.eventId}">
                                <input type ="submit" name="command" value="makeSpeaker"></form>

                        </tr>
                    </c:forEach>
                </c:when>
            </c:choose>

        </table>


    </div>
</div>
        </div>

</div>
