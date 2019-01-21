package service.impl;

import com.google.protobuf.ServiceException;
import dao.EmployeeDAO;
import dao.factory.DaoFactory;
import domain.to.Employee;
import exception.DaoException;
import org.apache.commons.codec.digest.DigestUtils;
import service.EmployeeService;
import service.validator.LoginValidator;
import service.validator.ValidationException;
import service.validator.ValidatorInterface;

import java.util.List;

/**
 * Created by user on 17.01.2019.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();
    private static final ValidatorInterface<Employee> VALIDATE = LoginValidator.getInstance();

    private EmployeeServiceImpl(){}

    public static EmployeeService getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public Employee authorization(Employee employee) throws ServiceException {
        try {
            EmployeeDAO employeeDao = factory.getEmployeeDao();

            if(VALIDATE.isValid(employee)) {

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
    private static class SingletonHolder {
        private static final EmployeeServiceImpl instance = new EmployeeServiceImpl();
    }

    public Employee create(Employee obj) throws ServiceException {
        throw new UnsupportedOperationException();
    }


    public List<Employee> viewAll() throws ServiceException {
        throw new UnsupportedOperationException();
    }

}
