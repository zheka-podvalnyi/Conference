package ua.nure.podvalnyi.web.utils;

public final class Const {

    //JDBC INIT
    public static final String JDBC_URL = "jdbc.url";
    public static final String JDBC_NAME = "jdbc.name";
    public static final String JDBC_PASSWORD = "jdbc.password";
    public static final String JDBC_TIMEZONE = "jdbc.timezone";

    //Forward PAGES

    public static final String PROFILE = "profile.jsp";
    public static final String REGISTER = "pages/login.jsp?success=9";
    public static final String MAIN = "pages/main.jsp";
    public static final String LOGIN = "pages/login.jsp";
    public static final String CONFIRM_PASSWORD = "controller1?command=profile&success=6";
    public static final String CHANGE_PASSWORD_FORM = "/WEB-INF/change_password.jsp";
    public static final String CHANGE_PASSWORD_AUTH = "controller1?command=profile&info=mail";
    public static final String CHANGE_PASSWORD_NOT_AUTH = "pages/login.jsp?info=mail";

    public static final String REGISTER_TO_EVENT = "registerToEvent.jsp";

    public static final String REQUEST_LIST ="requestList.jsp";


    public static final String MODER_PAGE = "moder_page.jsp";
    public static final String MODER_REGISTRATION = "moder_registration.jsp";

    public static final String REPORT_FORM = "report.jsp";


    public static final String ADD_EVENT = "controller1?command=addEvent";
    public static final String EVENT_FORM = "events.jsp";


    public static final String ALL_REPORTS = "controller1?command=allReports";
    public static final String ALL_USERS = "controller1?command=allUsers";

    public static final String CONFIRM_REQUEST = "controller1?command=requestListForm";

    public static final String EVENTS ="events.jsp";



    public static final String STATISTIC = "myStatistic.jsp";


    public static final String EDIT_EVENT_FORM = "edit_event_form.jsp";



}
