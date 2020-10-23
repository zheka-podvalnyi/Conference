package ua.nure.podvalnyi.db.service.implement;

import ua.nure.podvalnyi.db.dao.StatisticDbDao;
import ua.nure.podvalnyi.db.dao.UserDbDao;
import ua.nure.podvalnyi.db.entity.Statistic;
import ua.nure.podvalnyi.db.service.StatisticService;
import ua.nure.podvalnyi.exception.DBException;
import ua.nure.podvalnyi.transaction.TransactionManager;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StatisticServiceImpl implements StatisticService {


    private StatisticDbDao statisticDbDao;
    private TransactionManager transactionManager;

    public StatisticServiceImpl(StatisticDbDao statisticDbDao, TransactionManager transactionManager) {
        this.statisticDbDao = statisticDbDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public Statistic getStatisticByUserId(Long userId) throws DBException {
        return transactionManager.useWithOutTransaction(connection -> statisticDbDao.getStatisticByUserId(connection, userId));
    }

    @Override
    public List getStatisticByEventId(Long eventId) throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection -> statisticDbDao.getStatisticByEventId(connection, eventId)))
                .orElse(Collections.emptyList());
    }

    @Override
    public Long addStatistic(Statistic statistic) throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection ->
                statisticDbDao.addStatistic(connection, statistic))).orElse(-1L);
    }

    @Override
    public Long countStatistic(Long eventId) throws DBException {
        return Optional.ofNullable(transactionManager.useWithOutTransaction(connection ->
                statisticDbDao.countStatistic(connection, eventId))).orElse(-1L);
    }
}
