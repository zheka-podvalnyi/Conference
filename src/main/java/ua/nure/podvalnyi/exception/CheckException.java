package ua.nure.podvalnyi.exception;

public class CheckException {

    public static String Cause(Exception ex){
        if(ex.getMessage().contains("user_login")){
            return "This login is already used";
        }
        if(ex.getMessage().contains("user_mail")){
            return "This mail is already used";
        }
        if (ex.getMessage().contains("user_phone")) {
            return "This phone already used";
        }

        return "SQL exception";
    }
}
