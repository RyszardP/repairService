package dao;


import domain.to.Faults;
import exception.DaoException;
import javafx.application.Application;

import java.util.List;

/**
 * Interface for Faults table in database with concrete parameters.
 * Provides specific method with {@link Faults} objects
 */

public interface FaultsDAO extends GenericDAO<Faults, Integer> {

    /**
     * Method checks faults to be present in the database
     *
     * @param faults object that will be checks for the presence of in database
     * @return boolean result of operation
     * @throws DaoException
     */
    boolean checkFaults(Faults faults) throws DaoException;

    /**
     * Method find all nodes from database which satisfy the conditions of application
     *
     * @param app facility which searches
     * @return list nodes that can be find in database
     * @throws DaoException
     */
    List<Faults> findByApplication(Application app) throws DaoException;
}
