package ua.nure.podvalnyi.web.command;

import org.apache.log4j.Logger;
import ua.nure.podvalnyi.db.Initializer;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.UserService;
import ua.nure.podvalnyi.exception.AppException;
import ua.nure.podvalnyi.web.command.user.RegisterCommand;
import ua.nure.podvalnyi.web.utils.PasswordEncryption;
import ua.nure.podvalnyi.web.utils.Validation;

import javax.servlet.ServletRequest;
import java.sql.Date;
import java.time.LocalDate;

public class Register {

    private static final Logger LOG = Logger.getLogger(RegisterCommand.class);

    public static Long createUser(ServletRequest request,String permission) throws AppException{
        Initializer initializer = Initializer.getInstance();

        UserService<User> userService = initializer.getUserService();

        String name = request.getParameter("name");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String mail = request.getParameter("mail");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        LOG.trace("Get parameters --> name: " + name + "lastName: " + lastName + "middleName: " + middleName + "mail: "
                + mail + "birthday: "+ birthday + "login: " + login);

        Validation.validateRegistration(login,name,middleName,lastName,mail,birthday,password);

        LocalDate localDate = birthday.toLocalDate();
        localDate = localDate.plusDays(1);
        birthday = Date.valueOf(localDate);

        password = PasswordEncryption.encryptPassword(request.getParameter("password"));
        User user = new User(name, middleName, lastName, mail, birthday, login, password, permission);
        LOG.info("User created");
        return userService.addUser(user);
    }
}
