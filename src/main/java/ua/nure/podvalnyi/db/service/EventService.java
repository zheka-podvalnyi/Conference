package ua.nure.podvalnyi.db.service;

import ua.nure.podvalnyi.db.entity.Event;
import ua.nure.podvalnyi.exception.DBException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface EventService<E extends Event> {
    List<E> getListOfEvents() throws DBException;

    E getEventById(Long id) throws DBException;

    List<E> getEventsByUser(Long userId) throws DBException;

    E getEventByName(String name) throws DBException;

    Long addEvent(E event) throws DBException;

    boolean removeEventById(Long id) throws DBException;

    boolean changeEvent(E event) throws DBException;

    List<E> sortEventByDateUp()throws DBException;

    List<E> sortEventByDateDown()throws DBException;

    List<E> sortEventByAmountOfUsersUp () throws DBException;

    List<E> sortEventByAmountOfUsersDown () throws DBException;

    Long joinToEvent(Long userId, Long eventId) throws DBException;


}
