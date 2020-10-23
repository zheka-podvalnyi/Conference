package ua.nure.podvalnyi.web.utils;

import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.exception.AppException;

import java.sql.Date;

public class Validation {

    public static boolean validateRegistration(
            String login, String name, String lastName, String middleName, String mail, Date birthday,String password) throws AppException{
        if(!name.matches("(?u)((\\p{Lu})(\\p{Ll}{1,15}))") || !lastName.matches("(?u)((\\p{Lu})(\\p{Ll}{1,15}))") ||
                !middleName.matches("(?u)((\\p{Lu})(\\p{Ll}{1,15}))")) {
            throw new AppException("Invalid format of name");
        }
        if (!mail.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
            throw new AppException("Invalid format of email");
        }

        if (birthday.compareTo(DateTime.dateOfMajority()) > 0) {
            throw new AppException("You are not 18 years old");
        }
        checkPassword(password);
        checkLogin(login);
        return true;
    }

    public static boolean confirmPassword(String password, String security) throws AppException {
        if (security == null || !security.equals(PasswordEncryption.encryptPassword(password))) {
            throw new AppException("Security code not correct");
        }
        return true;
    }



    public static boolean checkPassword(String password) throws AppException {
        if (password == null || password.length() > 32) {
            throw new AppException("Invalid password format ");
        }
        return true;
    }

    public static boolean equalsPasswords(String password1, String password2) throws AppException {
        if (!password1.equals(password2)) {
            throw new AppException("Password not correct");
        }
        return true;
    }

    public static boolean checkLogin(String login) throws AppException {
        if (login == null || login.isEmpty()) {
            throw new AppException("Login is empty");
        }
        if (!login.matches("^(?!.*__.*)(?!.*\\.\\..*)[a-z0-9_.]{3,15}$")) {
            throw new AppException("Invalid format of login");
        }
        return true;
    }

    public static boolean checkUser(User user) throws AppException{
        if (user == null) {
            throw new AppException("User not found");
        }
    return true;
    }
}

