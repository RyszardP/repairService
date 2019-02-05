package com.htp.repairService.service.impl;


import com.htp.repairService.dao.EmployeeDAO;
import com.htp.repairService.dao.factory.DaoFactory;
import com.htp.repairService.domain.to.Employee;
import com.htp.repairService.domain.to.Faults;
import com.htp.repairService.exception.DaoException;
import com.htp.repairService.service.ServiceException;
import org.apache.commons.codec.digest.DigestUtils;
import com.htp.repairService.service.EmployeeService;
import com.htp.repairService.service.validator.LoginValidator;
import com.htp.repairService.service.validator.ValidationException;
import com.htp.repairService.service.validator.ValidatorInterface;


import java.util.List;

/**
 * Created by user on 17.01.2019.
 */

/**
 * Implements the actions that the system can perform with the object {@link Employee}
 */
public class EmployeeServiceImpl implements EmployeeService {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();

    private static final ValidatorInterface<Employee> VALIDATE = LoginValidator.getInstance();

    private EmployeeServiceImpl() {
    }

    public static EmployeeService getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public Employee authorization(Employee employee) throws ServiceException {
        try {
            EmployeeDAO employeeDao = factory.getEmployeeDao();

            if (VALIDATE.isValid(employee)) {

                String password = employee.getPassword();
                String passwordMD5 = DigestUtils.md5Hex(password);
                employee.setPassword(passwordMD5);

                boolean check = employeeDao.checkEmployee(employee.getLogin(), employee.getPassword());
                if (!check) {
                    return null;
                } else {
                    return employeeDao.getEmployeeNode(employee.getLogin(), employee.getPassword());
                }
            } else {
                throw new ValidationException("Validation Exception");
            }
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }



    @Override
    public List loadAll() throws ServiceException {
        return null;
    }

    private static class SingletonHolder {
        private static final EmployeeServiceImpl instance = new EmployeeServiceImpl();
    }

    @Override
    public Employee create(Employee employee) throws ServiceException {

        try {
            if(VALIDATE.isValid(employee)) {
                String password = employee.getPassword();
                String passwordMD5 = DigestUtils.md5Hex(password);
                employee.setPassword(passwordMD5);
                EmployeeDAO userDao = factory.getEmployeeDao();

                boolean check = userDao.checkEmployeeReg(employee);
                if (!check) {
                    long id = userDao.create(employee);
                    employee.setEmployee_id((int) id);
                    return employee;
                } else {
                    return null;
                }
            } else {
                throw new ValidationException("Validation Exception");
            }
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }


    @Override
    public Faults create(Object entity) throws ServiceException {
        return null;
    }

    public List<Employee> viewAll() throws ServiceException {
        throw new UnsupportedOperationException();
    }

}
