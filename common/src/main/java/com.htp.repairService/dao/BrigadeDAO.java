package com.htp.repairService.dao;


import com.htp.repairService.domain.to.Brigade;
import com.htp.repairService.exception.DaoException;

public interface BrigadeDAO extends GenericDAO<Brigade,Integer> {
    /**
     * Method checks brigades  to be present in the database
     *
     * @param brigade object that will be checks for the presence of in database
     * @return boolean result of operation
     * @throws DaoException
     */
    boolean checkBrigade(Brigade brigade) throws DaoException;
}
