package ua.nure.podvalnyi.db.functional;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface Function<T> {

    T execute(Connection connection) throws SQLException;
}
