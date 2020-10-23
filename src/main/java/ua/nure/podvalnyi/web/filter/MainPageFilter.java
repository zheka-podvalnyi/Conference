package ua.nure.podvalnyi.web.filter;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/pages/main.jsp"})
public class MainPageFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(MainPageFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.debug("Filter initialization starts");
        // no op
        LOG.debug("Filter initialization finished");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpRequest.getSession();
        if (session.getAttribute("user") == null) {
            httpResponse.sendRedirect("login.jsp");
        } else {
            User user = (User) session.getAttribute("user");
            if (user.getPermission().equals("moderator")) {
                httpResponse.sendRedirect("/Conference/controller1?command=allUsers");
            }
        }
        filterChain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {
        LOG.debug("Filter destruction starts");
        // no op
        LOG.debug("Filter destruction finished");
    }
}
