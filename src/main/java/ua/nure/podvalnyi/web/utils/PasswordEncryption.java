package ua.nure.podvalnyi.web.utils;

import java.util.logging.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static java.util.logging.Level.SEVERE;

public class PasswordEncryption {

    private static MessageDigest messageDigest;

    public static String encryptPassword(String password){

        try {
        messageDigest = MessageDigest.getInstance("MD5");
        byte[] passwordBytes = password.getBytes();
        messageDigest.reset();
        byte[] digested = messageDigest.digest(passwordBytes);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < digested.length; i++) {
            sb.append(Integer.toHexString(0xff & digested[i]));
        }
    return sb.toString();
    }catch(NoSuchAlgorithmException ex){
            Logger.getLogger(PasswordEncryption.class.getName()).log(SEVERE,null,ex);
        }
        return null;
    }
}
