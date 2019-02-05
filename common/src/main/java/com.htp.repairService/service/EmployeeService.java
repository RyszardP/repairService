package com.htp.repairService.service;



import com.htp.repairService.domain.to.Employee;

import java.util.List;

public interface EmployeeService extends GenericServiceInterface {

    /**
     * Method provides operation for login user
     *
     * @param employee object, that provides authorization operation
     * @return {@link Employee} - login record
     * @throws ServiceException
     */

    Employee authorization(Employee employee) throws ServiceException;

    Employee create(Employee employee) throws ServiceException;

    List<Employee> viewAll() throws ServiceException;
}