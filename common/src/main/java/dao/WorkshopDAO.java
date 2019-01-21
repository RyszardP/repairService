package dao;

import domain.to.Workshop;
import exception.DaoException;

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
