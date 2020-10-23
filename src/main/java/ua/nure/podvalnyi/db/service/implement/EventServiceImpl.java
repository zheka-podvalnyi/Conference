package ua.nure.podvalnyi.db.service.implement;

import ua.nure.podvalnyi.db.dao.EventDbDao;
import ua.nure.podvalnyi.db.dao.implement.EventDbDaoImpl;
import ua.nure.podvalnyi.db.entity.Event;
import ua.nure.podvalnyi.db.service.EventService;
import ua.nure.podvalnyi.exception.DBException;
import ua.nure.podvalnyi.transaction.TransactionManager;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EventServiceImpl implements EventService {

    private EventDbDao eventDbDao;
    private TransactionManager transactionManager;
    public EventServiceImpl(EventDbDaoImpl eventDbDao, TransactionManager transactionManager) {
        this.eventDbDao = eventDbDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public List getListOfEvents() throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> eventDbDao.getEvents(connection)))
                .orElse(Collections.emptyList());
    }

    @Override
    public Event getEventById(Long id) throws DBException {
       return transactionManager.useWithOutTransaction(connection -> eventDbDao.getEventById(connection, id));

    }

    @Override
    public List getEventsByUser(Long userId) throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> eventDbDao.getEventsByUser(connection,userId)))
                .orElse(Collections.emptyList());
    }

    @Override
    public Event getEventByName(String name) throws DBException {
        return transactionManager.useWithOutTransaction(connection -> eventDbDao.getEventByName(connection, name));
    }

    @Override
    public Long addEvent(Event event) throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(
                connection -> eventDbDao.addEvent(connection, event))).orElse(-1L);    }

    @Override
    public boolean removeEventById(Long id) throws DBException {
        return transactionManager.useWithOutTransaction(connection -> eventDbDao.removeEventById(connection, id));
    }

    @Override
    public boolean changeEvent(Event event) throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> eventDbDao.changeEvent(connection, event)))
                .isPresent();
    }

    @Override
    public List sortEventByDateUp() throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> eventDbDao.sortEventByDateUp(connection)))
                .orElse(Collections.emptyList());
    }

    @Override
    public List sortEventByDateDown() throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> eventDbDao.sortEventByDateDown(connection)))
                .orElse(Collections.emptyList());
    }

    @Override
    public List sortEventByAmountOfUsersUp() throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> eventDbDao.sortEventByAmountOfUsersUp(connection)))
                .orElse(Collections.emptyList());
    }

    @Override
    public List sortEventByAmountOfUsersDown() throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> eventDbDao.sortEventByAmountOfUsersDown(connection)))
                .orElse(Collections.emptyList());
    }


    @Override
    public Long joinToEvent(Long userId, Long eventId) throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(
                connection -> eventDbDao.joinToEvent(connection, userId,eventId))).orElse(-1L);
    }
}
