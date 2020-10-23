package ua.nure.podvalnyi.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.UserService;
import ua.nure.podvalnyi.web.command.Command;
import ua.nure.podvalnyi.web.utils.PasswordEncryption;
import ua.nure.podvalnyi.web.utils.SendEmailNotification;
import ua.nure.podvalnyi.web.utils.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static ua.nure.podvalnyi.web.utils.Const.CHANGE_PASSWORD_AUTH;
import static ua.nure.podvalnyi.web.utils.Const.CHANGE_PASSWORD_NOT_AUTH;

public class ChangePasswordCommand extends Command {

    private static final  Logger LOG = Logger.getLogger(ConfirmPasswordCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Command starts");
        Initializer initializer = Initializer.getInstance();
        UserService<User> userService  = initializer.getUserService();
        HttpSession session = request.getSession();
        User user;
        String login;
        String forward = CHANGE_PASSWORD_AUTH;

        if(session.getAttribute("user") == null) {
            LOG.trace("User not authorized");
            login = request.getParameter("login");
            Validation.checkLogin(login);
            LOG.trace("Get request parameter 'login' -->" + login);
            user = userService.getUserByLogin(login);
            Validation.checkUser(user);
            LOG.trace("Received user by user login -->" + user);
            forward = CHANGE_PASSWORD_NOT_AUTH;
        } else {
            user = (User) session.getAttribute("user");
            LOG.trace("User authorized --> " + user);
            login = user.getLogin();
        }
        String password = request.getParameter("password");
        Validation.checkPassword(password);
        password = PasswordEncryption.encryptPassword(password);
        LOG.info("Password was crypted");
        String text = "Hello," + user.getName() + " " + user.getLastName() + "." + System.lineSeparator() +
                "To change password, you must click here: " + "http:localhost:8080" + request.getContextPath()
                + "/controller1?command=confirmPassword&login=" + login + "&password=" + password + "&security="
                + PasswordEncryption.encryptPassword(user.getPassword());
        SendEmailNotification.mail(text, user.getMail());
        LOG.trace("Message was successfully delivered to " + user.getMail());
        LOG.debug("Command finished");
        return forward;
    }
}
