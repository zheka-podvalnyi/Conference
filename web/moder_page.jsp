<%--
  Created by IntelliJ IDEA.
  User: Zhekan
  Date: 17.10.2020
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<style>
    body {
        color: #fff;
        background: #63738a;
        font-family: 'Roboto', sans-serif;
    }

    button[id="sort"] {
        margin-right: 10px;
    }

    input[id="unblock"], input[id="block"] {
        margin-right: 10px;
    }

    table {
        background-color: white;
    }
</style>
<%@ include file="/WEB-INF/jspf/adminbar.jspf" %>
<div class="container">
    <c:choose>
    <c:when test="${requestScope.users!=null}">
        <c:set var="body">
            <div class="form-group">
                <legend class="control-label text-info display-3 ">
                    <fmt:message bundle="${message}"
                                 key="admin.list_of_profiles"/>
                </legend>
            </div>
            <div class="form-group">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col"><fmt:message bundle="${message}"
                                                     key="global.name"/></th>
                        <th scope="col"><fmt:message bundle="${message}"
                                                     key="global.lastname"/></th>
                        <th scope="col"><fmt:message bundle="${message}"
                                                     key="global.middlename"/></th>
                        <th scope="col"><fmt:message bundle="${message}"
                                                     key="global.phone"/></th>
                        <th scope="col"><fmt:message bundle="${message}"
                                                     key="global.mail"/></th>
                        <th scope="col"><fmt:message bundle="${message}"
                                                     key="global.username"/></th>
                        <th scope="col"><fmt:message bundle="${message}"
                                                     key="global.permission"/></th>

                    </tr>
                    </thead>



                        <tbody>
                        <tr>
                            <th scope="col">${item.id}</th>
                            <th scope="col">${item.name}</th>
                            <th scope="col">${item.lastName}</th>
                            <th scope="col">${item.middleName}</th>

                            <th scope="col">${item.mail}</th>
                            <th scope="col">${item.login}</th>
                            <th scope="col">${item.permission}</th>


                        </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
        </c:set>
    </c:when>
    <c:when test="${requestScope.events!=null}">
        <c:set var="body">
            <div class="form-group">
                <legend class="control-label text-info display-3 ">
                    <fmt:message bundle="${message}"
                                 key="admin.list_of_event"/>
                </legend>
                <form action="${pageContext.request.contextPath}/controller1">
                    <div class="form-inline">
                        <input type="hidden" name="command" value="allCards">
                        <button id="sort" class="btn btn-success" type="submit"><fmt:message bundle="${message}"
                                                                                             key="sort.cards"/></button>
                        <select id="approv_status" name="sortBy" class="form-control">
                            <option value="idUp"><b><fmt:message bundle="${message}" key="sort.up_by_id"/></b>
                            </option>
                            <option value="idDown"><b><fmt:message bundle="${message}" key="sort.down_by_id"/></b>
                            </option>
                            <option value="userUp"><b><fmt:message bundle="${message}" key="sort.up_by_card_user"/></b>
                            </option>
                            <option value="userDown"><b><fmt:message bundle="${message}"
                                                                     key="sort.down_by_card_user"/></b>
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
                        <th scope="col"><fmt:message bundle="${message}" key="card.card_number"/></th>
                        <th scope="col"><fmt:message bundle="${message}" key="bank.number"/></th>
                        <th scope="col"><fmt:message bundle="${message}" key="global.user"/></th>
                        <th scope="col"><fmt:message bundle="${message}" key="global.actions"/></th>
                    </tr>
                    </thead>

                    <c:forEach var="item" items="${requestScope.cards}">

                        <tbody>
                        <tr>
                            <th scope="col">${item.id}</th>
                            <th scope="col">${item.number}</th>
                            <th scope="col">${item.bankAccountId}</th>
                            <th scope="col">${item.userId}</th>
                            <th scope="col">
                                <form action="${pageContext.request.contextPath}/controller1" method="get">
                                    <input type="submit" class="form-group btn btn-block btn-danger"
                                           value="<fmt:message bundle="${message}" key="bank.number"/>">
                                    <input type="hidden" name="command" value="bankAccountInfo">
                                    <input type="hidden" name="bankAccountId" value="${item.bankAccountId}">
                                    <input type="hidden" name="cardId" value="${item.id}">
                                </form>
                            </th>
                        </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
        </c:set>
    </c:when>


    <c:when test="${requestScope.history!=null}">
        <c:set var="body">
            <div class="form-group">
                <legend class="control-label text-info display-3 ">
                    <fmt:message bundle="${message}" key="admin.list_of_payments"/>
                </legend>
                <form action="${pageContext.request.contextPath}/controller1">
                    <div class="form-inline">
                        <input type="hidden" name="command" value="allEvents">
                        <button id="sort" class="btn btn-success" name="sort" type="submit"><fmt:message bundle="${message}"
                                                                                                         key="sort.payments"/></button>
                        <select id="approv_status" name="sortBy" class="form-control">
                            <option value="numberUp"><b><fmt:message bundle="${message}"
                                                                     key="sort.up_by_payment_number"/></b></option>
                            <option value="numberDown"><b><fmt:message bundle="${message}"
                                                                       key="sort.down_by_payment_number"/></b></option>
                            <option value="dateUp"><b><fmt:message bundle="${message}" key="sort.up_by_date"/></b>
                            </option>
                            <option value="dateDown"><b><fmt:message bundle="${message}" key="sort.down_by_date"/></b>
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
                        <th scope="col"><fmt:message bundle="${message}" key="global.type"/></th>
                        <th scope="col"><fmt:message bundle="${message}" key="global.amount"/></th>
                        <th scope="col"><fmt:message bundle="${message}" key="global.message"/></th>
                        <th scope="col"><fmt:message bundle="${message}" key="payment.date"/></th>
                        <th scope="col"><fmt:message bundle="${message}" key="payment.sender"/></th>
                        <th scope="col"><fmt:message bundle="${message}" key="payment.receiver"/></th>
                    </tr>
                    </thead>

                    <c:forEach var="item" items="${requestScope.history}">

                        <tbody>
                        <tr>
                            <th scope="col">${item.id}</th>
                            <th scope="col">${item.type}</th>
                            <th scope="col">${item.amount}</th>
                            <th scope="col">${item.message}</th>
                            <th scope="col">${item.date} ${item.time}</th>
                            <th scope="col">${item.cardIdSender}</th>
                            <th scope="col">${item.cardIdReceiver}</th>
                        </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
        </c:set>
    </c:when>
    <c:when test="${requestScope.bankAccount!=null}">
    <c:set var="body">
    <div class="row">
        <legend class="control-label text-info display-3 ">
            <fmt:message bundle="${message}" key="bank.number"/>
        </legend>
        <table class="table table-bordered success">
            <thead>
            <tr>
                <th class="info"><fmt:message bundle="${message}" key="bank.bank_type"/></th>
                <td>${requestScope.bankAccount.name}</td>
            </tr>
            <tr>
                <th><fmt:message bundle="${message}" key="card.card_number"/></th>
                <td>${requestScope.card.number}</td>
            </tr>
            <tr>
                <th class="info"><fmt:message bundle="${message}" key="bank.number"/></th>
                <td>${requestScope.bankAccount.number}</td>
            </tr>
            <tr>
                <th class="info"><fmt:message bundle="${message}" key="card.card_balance"/></th>
                <td>${requestScope.bankAccount.balance}</td>
            </tr>

            <tr>
                <th class="info"><fmt:message bundle="${message}" key="bank.cvv"/></th>
                <td>
                    <b>***</b>
                </td>
            </tr>

            <tr>
                <th class="info">Status</th>
                <td><b>${requestScope.bankAccount.status}</b></td>
            </tr>

            <tr>
                <th class="info"><fmt:message bundle="${message}" key="payment.action"/></th>
                <td class="form-inline">

                    <c:choose>
                        <c:when test="${requestScope.bankAccount.status=='blocked'}">
                            <form action="${pageContext.request.contextPath}/controller1" method="post">
                                <input type="submit" id="unblock" class="btn btn-primary"
                                       value="<fmt:message bundle="${message}" key="global.unblock"/>">
                                <input type="hidden" name="command" value="bankAction">
                                <input type="hidden" name="bankAccountId" value="${requestScope.bankAccount.id}">
                                <input type="hidden" name="cardId" value="${requestScope.card.id}">
                                <input type="hidden" name="operation" value="unblock">
                            </form>
                        </c:when>
                        <c:when test="${requestScope.bankAccount.status=='unblocked'}">
                            <form action="${pageContext.request.contextPath}/controller" method="post">
                                <input type="submit" id="block" class="btn  btn-danger"
                                       value="<fmt:message bundle="${message}" key="global.block"/>">
                                <input type="hidden" name="command" value="bankAction">
                                <input type="hidden" name="bankAccountId" value="${requestScope.bankAccount.id}">
                                <input type="hidden" name="cardId" value="${requestScope.card.id}">
                                <input type="hidden" name="operation" value="block">
                            </form>
                        </c:when>
                    </c:choose>
                    <input form="back" type="submit" name="back_btn"
                           value="<fmt:message bundle="${message}" key="global.back"/>"
                           class="btn btn-warning">
                </td>
            </tr>
            </thead>
        </table>
    </div>
</div>
<form id="back" action="${pageContext.request.contextPath}/controller1" method="get">
    <input type="hidden" name="command" value="allCards">
</form>
</c:set>
</c:when>
<c:when test="${requestScope.reports!=null}">

    <div class="form-group">
        <legend class="control-label text-info display-3 ">
            <fmt:message bundle="${message}"
                         key="admin.list_of_reports"/>
        </legend>
        <form action="${pageContext.request.contextPath}/controller1">
            <div class="form-inline">
                <input type="hidden" name="command" value="allReports">
                <button id="sort" class="btn btn-success" name="sort" type="submit"><fmt:message bundle="${message}"
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
                <th scope="col">Action</th>
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
                    <th scope="col">
                        <c:if test="${item.type == 'new'}">
                            <div class="form-group">
                                <button type="button" id="reply" class="btn btn-success" data-toggle="modal"
                                        data-target="#modalContactForm${item.id}"><fmt:message bundle="${message}"
                                                                                               key="global.reply"/>
                                </button>
                            </div>
                        </c:if>
                    </th>
                </tr>
                </tbody>

                <form action="${pageContext.request.contextPath}/controller1" method="post">
                    <input type="hidden" name="command" value="replyReport">
                    <input type="hidden" name="reportId" value="${item.id}">

                    <div class="modal fade" id="modalContactForm${item.id}" tabindex="-1" role="dialog"
                         aria-labelledby="myModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header text-center">
                                    <h4 class="modal-title w-100 font-weight-bold text-danger"><fmt:message
                                            bundle="${message}"
                                            key="global.reply"/></h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body mx-3">
                                    <div class="md-form">
                                        <i class="fas fa-pencil prefix grey-text"></i>
                                        <textarea type="text" name="text" id="form8" class="md-textarea form-control"
                                                  rows="4" placeholder="Your message" maxlength="100"></textarea>
                                    </div>
                                </div>
                                <div class="modal-footer justify-content-center">
                                    <button type="submit" class="btn btn-success">Send</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </c:forEach>

        </table>
    </div>
</c:when>


</c:choose>
${body}

</body>
</html>
