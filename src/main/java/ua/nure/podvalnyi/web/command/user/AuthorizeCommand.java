package ua.nure.podvalnyi.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.UserService;
import ua.nure.podvalnyi.web.command.Command;
import ua.nure.podvalnyi.web.utils.PasswordEncryption;
import ua.nure.podvalnyi.web.utils.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static ua.nure.podvalnyi.web.utils.Const.MAIN;

public class    AuthorizeCommand extends Command {

    private static final Logger LOG = Logger.getLogger(AuthorizeCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        /**
         *
         * Initializing services
         *
         * **/
        HttpSession session = request.getSession();
        Initializer initializer = Initializer.getInstance();
        UserService<User> userService = initializer.getUserService();

        String login = request.getParameter("login");
        Validation.checkPassword(request.getParameter("password"));
        String password = PasswordEncryption.encryptPassword(request.getParameter("password"));

        Validation.checkUser(userService.getUserByLogin(login));
        User user = userService.getUserByLogin(login);
        Validation.equalsPasswords(password,user.getPassword());
        LOG.trace("Request parameter: login --> " + login + "Password was crypt" + "Found in DB: user --> "
                + user + "with permission --> " + user.getPermission());

        session.setAttribute("user" , user);

        LOG.info("User " + user + " logged as " + user.getPermission().toLowerCase());
        LOG.debug("Command finished");

        /**
         *
         * @return Link for redirect.
         *
         * **/

        return MAIN;

    }
}
