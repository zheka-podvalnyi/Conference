package ua.nure.podvalnyi.web.filter;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.UserService;
import ua.nure.podvalnyi.exception.AppException;
import ua.nure.podvalnyi.exception.DBException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebFilter(filterName = "filter2",
        servletNames = "controller",
        initParams = {
                @WebInitParam(name = "moderator", value = "editEventForm allUsers userAction getStatistic newModer createModer  addEvent addReport deleteEvent editEvent"),
                @WebInitParam(name = "user",value = "profile history addReport addEvent  joinToEvent"),
                @WebInitParam(name = "speaker",value = ""),
                @WebInitParam(name = "out-of-control", value = "myEvents confirmPassword changePassword makeNewPassword login logout registration changeLanguage authorize " +
                        "allEvents allReports sortEvents"),

        })
public class CommandAccessFilter implements Filter {

    private static final Logger LOG = LogManager.getLogger(CommandAccessFilter.class);
    //commands access
    private Map<String, List<String>> accessMap = new HashMap<String, List<String>>();
    private List<String> commons = new ArrayList<String>();
    private List<String> outOfControl = new ArrayList<String>();
    private List<String> blocked = new ArrayList<String>();

    @Override
    public void destroy() {
        LOG.debug("Filter destruction starts");
        //do nothing
        LOG.debug("Filter destruction finished");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOG.debug("Filter starts");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpRequest.getSession();
        User user = (User) session.getAttribute("user");
        try {
            if (accessAllowed(servletRequest)) {
                LOG.debug("Filter finished");
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                String errorMessage = "You do not have permission to access the requested resource or you are blocked.";

                servletRequest.setAttribute("errorMessage", errorMessage);
                LOG.trace("Set the request attribute: errorMessage --> " + errorMessage);
                servletRequest.getRequestDispatcher("pages/error.jsp")
                        .forward(servletRequest, servletResponse);
            }
        } catch (AppException e) {
            e.printStackTrace();
        }
    }

        private User updateUser(ServletRequest request) throws DBException {
            Initializer initializer = Initializer.getInstance();
            UserService<User> userService = initializer.getUserService();
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpSession session = httpRequest.getSession();
            if (session.getAttribute("user") == null) {
                return null;
            }
            User user = (User) session.getAttribute("user");
            return userService.getUserById(user.getId());
        }


    private boolean accessAllowed(ServletRequest request) throws AppException{
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String commandName = request.getParameter("command");

        if (commandName == null || commandName.isEmpty()) {
            return false;
        }

        if(outOfControl.contains(commandName)){
            return true;
        }

        HttpSession session = httpRequest.getSession(false);
        if (session == null) {
            return false;
        }

        session.setAttribute("user",updateUser(request));

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return false;
        }
        String userRole = user.getPermission();

        if (userRole == null) {
            return false;
        }
        return accessMap.get(userRole).contains(commandName);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.debug("Filter initialization starts");

        //roles
        accessMap.put("Moderator",asList(filterConfig.getInitParameter("moderator")));
        accessMap.put("Speaker",asList(filterConfig.getInitParameter("speaker")));
        accessMap.put("User", asList(filterConfig.getInitParameter("user")));
        LOG.trace("Access map --> " + accessMap);

        //out of control
        outOfControl = asList(filterConfig.getInitParameter("out-of-control"));
        LOG.trace("Out of control commands --> " + outOfControl);
        LOG.debug("Filter initialization finished");
    }

    /**
     * Extracts parameter values from string.
     *
     * @param str parameter values string.
     * @return list of parameter values.
     */
    private List<String> asList(String str){

        List<String> list = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()){
            list.add(st.nextToken());
        }
    return list;
    }
}
