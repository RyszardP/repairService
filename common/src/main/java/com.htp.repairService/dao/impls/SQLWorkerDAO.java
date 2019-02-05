package com.htp.repairService.dao.impls;


import com.htp.repairService.dao.WorkerDAO;
import com.htp.repairService.dao.connectionPool.ConnectionPool;
import com.htp.repairService.dao.connectionPool.ConnectionPoolException;
import com.htp.repairService.domain.to.WorkerBrigade;
import com.htp.repairService.exception.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLWorkerDAO implements WorkerDAO {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String SPECIALITY = "specialty";
    private static final String ROLE = "role";
    private static final String WORKER_ID = "worker_id";
    private static final String EMAIL = "email";

    private static final String SELECT_BY_ID = "SELECT * FROM worker_brigade WHERE worker_id = ?";
    private static final String SELECT_ALL_WORKERS = "SELECT * FROM worker_brigade";
    private static final String SELECT_BY_AUTHDATA = "SELECT * FROM worker_brigade WHERE  login = ? and password = ?";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    private SQLWorkerDAO() {    }

    private static class SingletonHolder {
        private static final WorkerDAO instance = new SQLWorkerDAO();
    }
    public static WorkerDAO getInstance() {
        return SingletonHolder.instance;
    }

    public boolean checkWorkerBrigade(String login, String password) throws DaoException {

        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_AUTHDATA)) {
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
    private WorkerBrigade getWorkerFromResultSet(ResultSet set) throws DaoException{
        try {
            WorkerBrigade workerBrigade = new WorkerBrigade();
            workerBrigade.setWorker_id(set.getInt(WORKER_ID));
            workerBrigade.setLogin(set.getString(LOGIN));
            workerBrigade.setPassword(set.getString(PASSWORD));
            workerBrigade.setRole(set.getString(ROLE));
            workerBrigade.setName(set.getString(NAME));
            workerBrigade.setSurname(set.getString(SURNAME));
            workerBrigade.setSpecialty(set.getString(SPECIALITY));
            workerBrigade.setEmail(set.getString(EMAIL));
            return workerBrigade;

        } catch (SQLException e) {
            throw new DaoException("Exception", e);
        }
    }
    public WorkerBrigade findById(Long id) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_BY_ID)) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();

            if(set.next()) {
                return getWorkerFromResultSet(set);
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }


    @Override
    public List<WorkerBrigade> findAll()throws DaoException{

            List<WorkerBrigade> workerBrigadeList = new ArrayList<>();
            try(Connection connect = pool.getConnection();
                PreparedStatement statement = connect.prepareStatement(SELECT_ALL_WORKERS)) {
                ResultSet set = statement.executeQuery();
                while(set.next()) {
                    WorkerBrigade worker = new WorkerBrigade();
                    worker.setLogin(set.getString(LOGIN));
                    worker.setPassword(set.getString(PASSWORD));
                    worker.setRole(set.getString(ROLE));
                    workerBrigadeList.add(worker);
                }
            } catch (SQLException | ConnectionPoolException e) {
                throw new DaoException("Exception", e);
            }
            return workerBrigadeList;
        }





    public WorkerBrigade getWorkerBrigadeNode(String login, String password) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_BY_AUTHDATA)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();

            if(set.next()) {
                return getWorkerFromResultSet(set);
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }


    @Override
    public WorkerBrigade findById(Integer id) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();

            if(set.next()) {
                WorkerBrigade workerBrigade = new WorkerBrigade();
                workerBrigade.setWorker_id(set.getInt(WORKER_ID));
                workerBrigade.setLogin(set.getString(LOGIN));
                workerBrigade.setPassword(set.getString(PASSWORD));

                return workerBrigade;
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public int create(WorkerBrigade entity) throws DaoException {
        return 0;
    }

    @Override
    public Integer update(WorkerBrigade entity) throws DaoException {
        return null;
    }



}
