package ua.nure.podvalnyi.db.dao;

import ua.nure.podvalnyi.db.entity.Event;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EventDbDao<E extends Event> {

    List<E> getEvents(Connection connection) throws SQLException;


    E getEventById(Connection connection,Long id) throws SQLException;

    List getEventsByUser(Connection connection, Long userId) throws SQLException;

    E getEventByName(Connection connection, String name) throws SQLException;

    Long addEvent(Connection connection, E event) throws SQLException;

    boolean removeEventById(Connection connection, Long id) throws SQLException;

    boolean changeEvent(Connection connection, E event) throws SQLException;

   List<E> sortEventByDateUp(Connection connection)throws SQLException;

    List<E> sortEventByDateDown(Connection connection)throws SQLException;

   List<E> sortEventByAmountOfUsersUp (Connection connection) throws SQLException;

    List<E> sortEventByAmountOfUsersDown (Connection connection) throws SQLException;

    List<E> sortEventByReportsUp(Connection connection)throws SQLException;

    List<E> sortEventByReportsDown(Connection connection)throws SQLException;

   Long joinToEvent(Connection connection, Long userId, Long eventId) throws SQLException;


}
