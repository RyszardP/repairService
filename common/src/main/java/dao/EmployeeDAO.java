package dao;

import domain.to.Employee;
import exception.DaoException;


/* Interface for Employee table in database with concrete parameters.
 * Provides specific method with {@link Employee} objects
 */

public interface EmployeeDAO extends GenericDAO<Employee, Integer> {
        /** Method get {@link Employee} object from database by login and password
         *
         * @param login login unique parameter
         * @param password password parameter
         * @return {@link Employee} object
         * @throws DaoException
         */
        Employee getEmployeeNode(String login, String password) throws DaoException;

        /**
         * Method check employee node in database by login and password transfers parameters
         *
         * @param login    login unique parameter
         * @param password password parameter
         * @return boolean result of operation
         * @throws DaoException
         */
        boolean checkEmployee(String login, String password) throws DaoException;
    }

