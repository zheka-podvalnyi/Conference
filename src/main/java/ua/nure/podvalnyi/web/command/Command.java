package ua.nure.podvalnyi.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

public abstract class Command implements Serializable {

    private static final long serialVersionUID =1L;

    public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

    @Override
    public final String toString() {
        return getClass().getSimpleName();
    }
}
