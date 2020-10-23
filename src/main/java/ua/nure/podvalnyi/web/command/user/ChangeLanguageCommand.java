package ua.nure.podvalnyi.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.web.command.Command;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.nure.podvalnyi.web.utils.Const.MAIN;

public class ChangeLanguageCommand extends Command {

    private static final Logger LOG = Logger.getLogger(ChangeLanguageCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        String language = request.getParameter("language");

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("language")){
                LOG.trace("Cookie with name 'lang' was found");
                cookie.setValue(language);
                response.addCookie(cookie);
                LOG.trace("Set value for cookie 'lang' -->" + language);
                LOG.debug("Command finished");
                return MAIN;
            }
        }
    Cookie cookie = new Cookie("language",language);
    response.addCookie(cookie);
    LOG.debug("Command finished");
    return MAIN;
    }
}
