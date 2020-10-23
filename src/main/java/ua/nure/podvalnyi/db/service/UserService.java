package ua.nure.podvalnyi.db.service;

import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.exception.DBException;

import java.sql.SQLException;
import java.util.List;

public interface UserService<E extends User> {

    List<E> getListOfUsers() throws DBException;

    E getUserById(Long id) throws DBException;

    E getUserByLogin(String login) throws DBException;

    List<String> getMailUsersByEventId(Long eventId) throws DBException;


    Long addUser(E user) throws DBException;

    boolean removeUserByLogin(String login) throws DBException;

    boolean changeUser(E user) throws DBException;

}
