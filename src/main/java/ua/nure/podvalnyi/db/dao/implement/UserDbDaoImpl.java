package ua.nure.podvalnyi.db.dao.implement;

import jdk.nashorn.internal.objects.annotations.Where;
import ua.nure.podvalnyi.db.dao.UserDbDao;
import ua.nure.podvalnyi.db.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDbDaoImpl implements UserDbDao {

    private static final String TABLE = "user";
    private static final String GET_ALL_USERS = "SELECT * FROM " + TABLE;
    private static final String GET_ALL_USERS_BY_EVENT_ID = "Select user_mail FROM " + TABLE + " WHERE user_id in(select user_id from statistic Where event_id=?);";
    private static final String GET_USER_BY_ID = "SELECT * FROM " + TABLE + " WHERE user_id=?";
    private static final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM " + TABLE + " WHERE user_login=?";
    private static final String ADD_USER = "INSERT INTO " + TABLE +
            " (user_name, user_middlename, user_lastname, user_mail, user_birthday, user_login, user_password, user_permission) " + " VALUES (?,?,?,?,?,?,?,?)";
    private static final String DELETE_USER_BY_LOGIN = "DELETE FROM " + TABLE + " WHERE user_login=?";
    private static final String CHANGE_USER = "UPDATE " + TABLE +
            " SET user_name=?,user_middlename=?,user_lastname=?,user_mail=?,user_birthday=?,user_login = ?," +
            "user_password = ?,user_permission=? WHERE user_id=?";


    @Override
    public List getUsers(Connection connection) throws SQLException {
        List<User> users = new ArrayList<>();
        String query = GET_ALL_USERS;
        try (PreparedStatement prepared = connection.prepareStatement(query);
             ResultSet resultSet = prepared.executeQuery()) {
            while (resultSet.next()) {
                User user = getUser(resultSet);
                user.setId(resultSet.getLong("user_id"));
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public List getMailUsersByEventId(Connection connection, Long eventId) throws SQLException {
        List<String> mails = new ArrayList<>();
        String query = GET_ALL_USERS_BY_EVENT_ID;
        try (PreparedStatement prepared = connection.prepareStatement(query)) {
            prepared.setLong(1, eventId);
            try (ResultSet resultSet = prepared.executeQuery()) {
                while (resultSet.next()) {

                    mails.add(resultSet.getString("user_mail"));
                }
            }
            return mails;
        }
    }

    @Override
    public User getUserById(Connection connection, Long id) throws SQLException {
        User user = null;
        String query = GET_USER_BY_ID;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = getUser(resultSet);
                    user.setId(resultSet.getLong("user_id"));
                }
            }
        }
        return user;
    }

    @Override
    public User getUserByLogin(Connection connection, String login) throws SQLException {
        User user = null;
        String query = SQL_FIND_USER_BY_LOGIN;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = getUser(resultSet);
                    user.setId(resultSet.getLong("user_id"));
                }
            }
        }
        return user;
    }

    @Override
    public Long addUser(Connection connection, User user) throws SQLException {
        String query = ADD_USER;
        Long id = 0L;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getMiddleName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getMail());
            preparedStatement.setDate(5, user.getBirthday());
            preparedStatement.setString(6, user.getLogin());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.setString(8, user.getPermission());
            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    id = resultSet.getLong(1);
                }
            }

        }
        return id;
    }

    @Override
    public boolean removeUserByLogin(Connection connection, String login) throws SQLException {
        String query = DELETE_USER_BY_LOGIN;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, login);

            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean changeUser(Connection connection, User user) throws SQLException {
        String query = CHANGE_USER;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getMiddleName());
            preparedStatement.setString(3, user.getLastName());

            preparedStatement.setString(4, user.getMail());
            preparedStatement.setDate(5, user.getBirthday());
            preparedStatement.setString(6, user.getLogin());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.setString(8, user.getPermission());
            preparedStatement.setLong(9, user.getId());
            return preparedStatement.executeUpdate() > 0;
        }
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getString("user_name"), resultSet.getString("user_middleName"),
                resultSet.getString("user_lastName"), resultSet.getString("user_mail"),
                resultSet.getDate("user_birthday"), resultSet.getString("user_login"),
                resultSet.getString("user_password"), resultSet.getString("user_permission"));
    }
}
