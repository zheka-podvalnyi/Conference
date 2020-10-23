<%--
  Created by IntelliJ IDEA.
  User: Zhekan
  Date: 14.10.2020
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container py-3">
<div class="signup-form">
    <form action="${pageContext.request.contextPath}/controller1" method="post">
        <input type="hidden" name="command" value="addReport">

        <h2><fmt:message bundle="${message}"
                         key="global.report"/></h2>
        <p class="hint-text"><fmt:message bundle="${message}"
                                          key="addreport.hint"/></p>


        <div class="form-group">
            <label class="checkbox-inline">
                <input type="checkbox" required="required">  <fmt:message bundle="${message}"
                                                                          key="register.i_accept_the"/> <a
                    href="#"><fmt:message bundle="${message}"
                                          key="register.terms_of_use"/></a>
                <a href="#"><fmt:message
                    bundle="${message}"
                    key="register.privacy_policy"/></a></label>
        </div>

        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textarea">Topic</label>
            <div class="col-md-4">
                <textarea class="form-control" id="textarea" name="textarea"></textarea>
            </div>
        </div>


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput"> Speaker</label>
            <div class="col-md-4">
                <input id="textinput" name="textinput" type="text" placeholder="Start Date" class="form-control input-md">
                <span class="help-block">help</span>
            </div>
        </div>

        <div class="form-group">
            <input type="submit" name="command" value="addReport"/> <fmt:message bundle="${message}"
                                                                                key="userbar.create_event"/>
        </div>


    </form>
</div>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
</body>
</html>