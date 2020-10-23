
<!doctype html>
<html lang="en">
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>

<c:if test="${not empty sessionScope.user}">
    <%@ include file="/WEB-INF/jspf/navbar.jspf" %>
</c:if>

<style type="text/css">
    body {
        color: #fff;
        background: #63738a;
        font-family: 'Roboto', sans-serif;
    }


    .form-control {
        height: 40px;

        box-shadow: none;
        color: #969fa4;
    }

    .form-control[name="name"] {
        margin-right: 7px;
    }

    .form-control[name="middleName"] {
        margin-right: 7px;
    }

    .form-control:focus {
        border-color: dodgerblue;
    }

    .form-control, .btn {
        border-radius: 3px;
    }

    .signup-form {
        width: 737px;
        margin: 0 auto;
        padding: 30px 0;
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
        min-width: 140px;
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
<div>
    <div class="signup-form">
        <form action="${pageContext.request.contextPath}/controller1" method="post">
            <input type="hidden" name="command" value="makeNewPassword">
            <h2><fmt:message bundle="${message}" key="profile.edit_profile"/></h2>
            <c:if test="${empty sessionScope.user}">
                <div class="form-group">
                    <input type="text" class="form-control" name="login" id=login"
                           placeholder="<fmt:message bundle="${message}" key="global.username"/>" required="required"
                           pattern="^(?!.*__.*)(?!.*\.\..*)[a-z0-9_.]{3,15}$">
                </div>
            </c:if>
            <div class="form-group">
                <input type="password" class="form-control" name="password" id=password"
                       placeholder="<fmt:message bundle="${message}" key="global.password"/>" required="required"
                       pattern="([\S]){6,32}">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="confirm_password" id="confirm_password"
                       placeholder="<fmt:message bundle="${message}" key="global.confirm_password"/>"
                       required="required">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-lg btn-block"><fmt:message bundle="${message}"
                                                                                            key="profile.change_password"/></button>
            </div>
        </form>
    </div>
</div>
<script>
    var password = document.getElementById("password")
        , confirm_password = document.getElementById("confirm_password");

    function validatePassword() {
        if (password.value != confirm_password.value) {
            confirm_password.setCustomValidity("Passwords Don't Match");
        } else {
            confirm_password.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    confirm_password.onkeyup = validatePassword;
</script>

</body>
</html>
