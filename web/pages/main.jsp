<%--
  Created by IntelliJ IDEA.
  User: Zhekan
  Date: 10.10.2020
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>--%>

<head>
    <title>Main</title>
    <%@ include file="/WEB-INF/jspf/head.jspf" %>

</head>
<body>
<style>
    body {
        background: #63738a;
    }

    .display-4 {
        padding-top: 20px;
    }

    .body h2 {
        padding-top: 20px;
        margin: 0 0 15px;
        position: relative;
        text-align: center;
    }


    .body h2:before {
        left: 0;
    }

    .body h2:after {
        right: 0;
    }

    .container {
        padding: 20px;
        display: flex;
        align-items: center;
    }

    .body {
        background: #f2f3f7;
        height: 590px;
        width: 600px;
        border-radius: 6px;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    }

    .body .btn {
        font-size: 16px;
        font-weight: bold;
        min-width: 140px;
        outline: none !important;
    }




     .img-container {
         text-align: center;
     }
 </style>
</style>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>

<div class="container">
<p>

<legend class="display-4  text-center text-succsess">
                                    <fmt:message bundle="${message}" key="global.hello"/>,
<b>${sessionScope.user.name} ${sessionScope.user.lastName},<br> </br>
<fmt:message bundle="${message}" key="global.welcome"/></b>
</legend>
</p> </div>
                                                                  <div class="img-container"><img src="/Conference/img/rocket-icon.jpg" alt="First slide">
                                                                                                                                                             </div>


</body>
     <%--       </table>
        </div>
    </form>
</div>
</div>
--%>

<%--<c:when test="${sessionScope.user.permission=='Moderator'}">
    <c:set var="body">

&lt;%&ndash;        <%@ include file="/WEB-INF/jspf/adminbar.jspf" %>&ndash;%&gt;
        <p>

        </p>
    </c:set>
</c:when>
        </c:set>
    </c:when>
</c:choose>--%>



