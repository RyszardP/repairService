package com.htp.repairService.dao;

import com.htp.repairService.domain.to.Employee;
import com.htp.repairService.exception.DaoException;


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


        boolean checkEmployee(String login, String password) throws DaoException;

        boolean checkEmployeeReg(Employee employee) throws DaoException;
    }

