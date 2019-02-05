package com.htp.repairService.dao;

import com.htp.repairService.domain.to.Workshop;
import com.htp.repairService.exception.DaoException;

public interface WorkshopDAO extends GenericDAO<Workshop, Integer> {
    /**
     * Method checks workshops to be present in the database
     *
     * @param workshop object that will be checks for the presence of in database
     * @return boolean result of operation
     * @throws DaoException
     */
    boolean checkWorkshop(Workshop workshop) throws DaoException;

}
