package ua.nure.podvalnyi.db.dao;

import ua.nure.podvalnyi.db.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDbDao<E extends User> {

    List<E> getUsers(Connection connection) throws SQLException;

    List<String> getMailUsersByEventId(Connection connection, Long eventId) throws SQLException;

    E getUserById(Connection connection, Long id) throws SQLException;

    E getUserByLogin(Connection connection, String login) throws SQLException;

    Long addUser(Connection connection, E user) throws SQLException;

    boolean removeUserByLogin(Connection connection, String login) throws SQLException;

    boolean changeUser(Connection connection, E user) throws SQLException;

}
