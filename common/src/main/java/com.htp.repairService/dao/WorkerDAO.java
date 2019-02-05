package com.htp.repairService.dao;


import com.htp.repairService.domain.to.WorkerBrigade;
import com.htp.repairService.exception.DaoException;

public interface WorkerDAO extends GenericDAO<WorkerBrigade, Integer> {
    /** Method get {@link WorkerBrigade} object from database by login and password
     *
     * @param login login unique parameter
     * @param password password parameter
     * @return {@link WorkerBrigade} object
     * @throws DaoException
     */
    WorkerBrigade getWorkerBrigadeNode(String login, String password) throws DaoException;

    /**
     * Method check worker node in database by login and password transfers parameters
     *
     * @param login    login unique parameter
     * @param password password parameter
     * @return boolean result of operation
     * @throws DaoException
     */
    boolean checkWorkerBrigade(String login, String password) throws DaoException;
}


