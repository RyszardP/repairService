package dao.impls;


import dao.EmployeeDAO;
import dao.connectionPool.ConnectionPool;
import dao.connectionPool.ConnectionPoolException;
import domain.to.Employee;
import exception.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 15.01.2019.
 */

public class SQLEmployeeDao implements EmployeeDAO {

    private static final String SELECT_BY_ID = "SELECT * FROM employee WHERE employee_id = ?";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee";
    private static final String SELECT_EMPLOYEE = "SELECT * FROM employee WHERE  login = ? and password = ?";
    private static final String UPDATE_EMPLOYEE = "UPDATE employee\n" +
            " SET login = ?\n" +
            " WHERE login = ?";


    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String SPECIALITY = "specialty";
    private static final String ROLE = "role";
    private static final String EMPLOYEE_ID = "employee_id";
    private static final String EMAIL = "email";


    private static final ConnectionPool pool = ConnectionPool.getInstance();

    private SQLEmployeeDao() {
    }

    private static class SingletonHolder {
        private static final EmployeeDAO instance = new SQLEmployeeDao();
    }
    public static EmployeeDAO getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public boolean checkEmployee(String login, String password) throws DaoException {

        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_EMPLOYEE)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    private Employee getEmployeeFromResultSet(ResultSet set) throws DaoException {
        try {
            Employee employee = new Employee();
            employee.setEmployee_id(set.getInt(EMPLOYEE_ID));
            employee.setLogin(set.getString(LOGIN));
            employee.setPassword(set.getString(PASSWORD));
            employee.setRole(set.getString(ROLE));
            employee.setName(set.getString(NAME));
            employee.setSurname(set.getString(SURNAME));
            employee.setSpecialty(set.getString(SPECIALITY));
            employee.setEmail(set.getString(EMAIL));


            return employee;

        } catch (SQLException e) {
            throw new DaoException("Exception", e);
        }
    }
    @Override
    public List<Employee> findAll() throws DaoException {
        List<Employee> employeeList = new ArrayList<>();
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_ALL_EMPLOYEES)) {
            ResultSet set = statement.executeQuery();
            while(set.next()) {
                Employee employee = new Employee();
                employee.setLogin(set.getString(LOGIN));
                employee.setPassword(set.getString(PASSWORD));
                employee.setRole(set.getString(ROLE));
                employeeList.add(employee);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return employeeList;
    }

    /**
     * Method find employee node in database by unique number
     * @param id unique number of node in database
     * @return employee object with all identification information: login, password, role, etc.;
     * null - if node can't be find in database
     * @throws DaoException if there were errors while reading employee from database.
     */
    @Override
    public  Employee findById(Integer id) throws DaoException {

        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                Employee employee = new Employee();
                employee.setEmployee_id(set.getInt(EMPLOYEE_ID));
                employee.setPassword(set.getString(PASSWORD));
                employee.setName(set.getString(NAME));
                return employee;
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("id Exception", e);
        }
    }



    @Override
    public Employee getEmployeeNode(String login, String password) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_EMPLOYEE)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();

            Employee employee = new Employee();
            employee.setEmployee_id(set.getInt(EMPLOYEE_ID));
            employee.setLogin(set.getString(LOGIN));
            employee.setPassword(set.getString(PASSWORD));
            employee.setRole(set.getString(ROLE));

            return employee;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }


    @Override
    public int create(Employee entity) throws DaoException {
        return 0;
    }

    @Override
    public Integer update(Employee entity) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }




}