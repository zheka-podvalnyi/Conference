package ua.nure.podvalnyi.transaction;

import com.mysql.cj.jdbc.MysqlDataSource;
import ua.nure.podvalnyi.db.functional.Function;
import ua.nure.podvalnyi.exception.CheckException;
import ua.nure.podvalnyi.exception.DBException;

import java.sql.Connection;
import java.sql.SQLException;


public class TransactionManager {

    private final MysqlDataSource dataSource;

    public TransactionManager(MysqlDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public <T> T useTransaction(Function<T> function) {
        T result = null;

        try (Connection connection = dataSource.getConnection()) {
            try {
                connection.setAutoCommit(false);
                result = function.execute(connection);
                connection.commit();
            } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException exception) {
                    System.out.println("SQL exception");
                } finally {
                    connection.setAutoCommit(true);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Start with SQL");
        }
        return result;
    }

    public <T> T useWithOutTransaction(Function<T> function) throws DBException{
        T result = null;
        try(Connection connection = dataSource.getConnection()){
            try {
                result = function.execute(connection);
            }catch (SQLException ex){
                System.out.println("SQL exception -->" + ex.getMessage());
            throw new DBException(CheckException.Cause(ex),ex);
            }
        }catch (SQLException ex){
            System.out.println("Start with SQL");
        }
        return result;
    }
}
