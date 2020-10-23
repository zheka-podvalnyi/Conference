package ua.nure.podvalnyi.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import ua.nure.podvalnyi.db.dao.implement.EventDbDaoImpl;
import ua.nure.podvalnyi.db.dao.implement.ReportDbDaoImpl;
import ua.nure.podvalnyi.db.dao.implement.StatisticDbDaoImpl;
import ua.nure.podvalnyi.db.dao.implement.UserDbDaoImpl;
import ua.nure.podvalnyi.db.entity.Event;
import ua.nure.podvalnyi.db.entity.Report;
import ua.nure.podvalnyi.db.entity.Statistic;
import ua.nure.podvalnyi.db.entity.User;
import ua.nure.podvalnyi.db.service.EventService;
import ua.nure.podvalnyi.db.service.ReportService;
import ua.nure.podvalnyi.db.service.StatisticService;
import ua.nure.podvalnyi.db.service.UserService;
import ua.nure.podvalnyi.db.service.implement.EventServiceImpl;
import ua.nure.podvalnyi.db.service.implement.ReportServiceImpl;
import ua.nure.podvalnyi.db.service.implement.StatisticServiceImpl;
import ua.nure.podvalnyi.db.service.implement.UserServiceImpl;
import ua.nure.podvalnyi.transaction.TransactionManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import static ua.nure.podvalnyi.web.utils.Const.*;

public class Initializer {



    private UserService<User> userService;
    private ReportService<Report> reportService;
    private EventService<Event> eventService;
    private StatisticService<Statistic> statisticService;

    public Initializer() {
        init();
    }

    private static Initializer instance;
    public static synchronized Initializer getInstance() {
        if (instance == null) {
            instance = new Initializer();
        }
        return instance;
    }

    private void init() {

        try {
            TransactionManager transactionManager = new TransactionManager(initMySqlConnection());
            userService = new UserServiceImpl(new UserDbDaoImpl(), transactionManager);
            reportService = new ReportServiceImpl(new ReportDbDaoImpl(),transactionManager);
            eventService = new EventServiceImpl(new EventDbDaoImpl(),transactionManager);
            statisticService = new StatisticServiceImpl(new StatisticDbDaoImpl(),transactionManager);

        } catch (IOException | SQLException e){
            System.out.println("Cannot initialize service");
            throw new RuntimeException();
        }
    }


    private MysqlDataSource initMySqlConnection() throws IOException, SQLException{
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(properties.getProperty(JDBC_NAME));
        dataSource.setPassword(properties.getProperty(JDBC_PASSWORD));
        dataSource.setUrl(properties.getProperty(JDBC_URL));
        dataSource.setServerTimezone(properties.getProperty(JDBC_TIMEZONE));
        return dataSource;
    }

    public UserService<User> getUserService(){
        return userService;
    }
    public ReportService<Report> getReportService(){return reportService; }
    public EventService<Event> getEventService(){return eventService;}
    public StatisticService<Statistic> getStatisticService(){
        return statisticService;
    }
}
