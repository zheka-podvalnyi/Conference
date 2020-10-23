
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<!doctype html>
<html lang="en">
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<style>
    body {
        background: #63738a;
    }

    button[name="sort"] {
        width: 210px;
        margin-right: 10px;
    }

    .table {
        background-color: white
    }
</style>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>

<div class="container">
    <form>
        <div class="form-group">
            <legend class="control-label text-info display-3 ">
                <fmt:message bundle="${message}" key="global.your_last_reports"/>
            </legend>
            <form action="${pageContext.request.contextPath}/controller1">
                <div class="form-inline">
                    <input type="hidden" name="command" value="reports">
                    <button class="btn btn-success" name="sort" type="submit"><fmt:message bundle="${message}"
                                                                                           key="sort.reports"/></button>
                    <select id="approv_status" name="sortBy" class="form-control">
                        <option value="typeUp"><b><fmt:message bundle="${message}"
                                                               key="sort.up_by_type"/></b></option>
                        <option value="typeDown"><b><fmt:message bundle="${message}"
                                                                 key="sort.down_by_type"/></b></option>
                        <option value="idUp"><b><fmt:message bundle="${message}" key="sort.up_by_id"/></b></option>
                        <option value="idDown"><b><fmt:message bundle="${message}" key="sort.down_by_id"/></b>
                        </option>
                    </select>

                </div>
            </form>
        </div>

        <div class="form-group">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col"><fmt:message bundle="${message}"
                                                 key="global.message"/></th>
                    <th scope="col"><fmt:message bundle="${message}"
                                                 key="report.answer"/></th>
                    <th scope="col"><fmt:message bundle="${message}"
                                                 key="global.type"/></th>
                    <th scope="col"><fmt:message bundle="${message}"
                                                 key="card.card_number"/></th>
                </tr>
                </thead>

                <c:forEach var="item" items="${requestScope.reports}">
                    <tbody>
                    <tr>
                        <th scope="col">${item.id}</th>
                        <th scope="col">${item.message}</th>
                        <th scope="col">${item.answer}</th>
                        <th scope="col">${item.type}</th>
                        <th scope="col">${item.cardNumber}</th>
                    </tr>
                    </tbody>

                </c:forEach>

            </table>
        </div>
    </form>
</div>

</body>
</html>
