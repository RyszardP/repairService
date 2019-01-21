package service;


import com.google.protobuf.ServiceException;
import domain.to.Employee;

public interface EmployeeService {

    Employee authorization(Employee employee) throws ServiceException;

}