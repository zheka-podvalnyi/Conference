package ua.nure.podvalnyi.db.service.implement;

import ua.nure.podvalnyi.db.dao.UserDbDao;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.UserService;
import ua.nure.podvalnyi.exception.DBException;
import ua.nure.podvalnyi.transaction.TransactionManager;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserDbDao userDbDao;
    private TransactionManager transactionManager;

    public UserServiceImpl(UserDbDao userDbDao, TransactionManager transactionManager) {
        this.userDbDao = userDbDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public List getListOfUsers() throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> userDbDao.getUsers(connection)))
                .orElse(Collections.emptyList());
    }

    @Override
    public User getUserById(Long id) throws DBException {
        return transactionManager.useWithOutTransaction(connection -> userDbDao.getUserById(connection, id));
    }

    @Override
    public User getUserByLogin(String login) throws DBException {
        return transactionManager.useWithOutTransaction(connection -> userDbDao.getUserByLogin(connection, login));
    }

    @Override
    public List<String> getMailUsersByEventId(Long eventId) throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> userDbDao.getMailUsersByEventId(connection,eventId)))
                .orElse(Collections.emptyList());
    }


    @Override
    public Long addUser(User user) throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection ->
                userDbDao.addUser(connection,user))).orElse(-1L);
    }

    @Override
    public boolean removeUserByLogin(String login) throws DBException {
        return transactionManager.useWithOutTransaction(connection -> userDbDao.removeUserByLogin(connection,login));
    }

    @Override
    public boolean changeUser(User user) throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> userDbDao.changeUser(connection, user)))
                .isPresent();    }
}
