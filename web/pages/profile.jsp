<!doctype html>
<html lang="en">
<title>Your profile</title>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@ include file="/WEB-INF/jspf/locale.jspf" %>

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

    tr {
        padding-right: 10px;
        padding-left: 10px;
    }

    a[name="back"] {
        margin-left: 10px
    }
</style>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>

<div class="container justify-content-center">
    <div class="body">


        <table class="table table-bordered">
            <h2 class="display-4 text-danger"><fmt:message bundle="${message}" key="global.profile"/></h2>
            <tbody>
            <tr>
                <td><fmt:message bundle="${message}" key="global.name"/>:</td>
                <td>${sessionScope.user.name}</td>
            </tr>
            <tr>
                <td><fmt:message bundle="${message}" key="global.middlename"/>:</td>
                <td>${sessionScope.user.middleName}</td>
            </tr>
            <tr>
                <td><fmt:message bundle="${message}" key="global.lastname"/>:</td>
                <td>${sessionScope.user.lastName}</td>
            </tr>

            <tr>

            <tr>
                <td><fmt:message bundle="${message}" key="global.username"/>:</td>
                <td>${sessionScope.user.login}</td>
            </tr>
            <tr>
                <td><fmt:message bundle="${message}" key="global.mail"/>:</td>
                <td>${sessionScope.user.mail}</td>
            </tr>

            <tr>
                <td><fmt:message bundle="${message}" key="global.birthdate"/>:</td>
                <td>${sessionScope.user.birthday}</td>
            </tr>

            </tbody>
        </table>
        <div class="form-inline justify-content-center">
            <a href="${pageContext.request.contextPath}/controller1?command=changePassword"
               class="btn btn-danger"><fmt:message bundle="${message}"
                                                   key="profile.change_password"/></a>
            <a name="back" href="${pageContext.request.contextPath}/pages/main.jsp" class="btn btn-warning"><fmt:message bundle="${message}"
                                                                                   key="global.back"/></a>
        </div>

    </div>
</div>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
</body>
</html>