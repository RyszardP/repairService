package com.htp.repairService.dao.impls;

import com.htp.repairService.dao.FaultsDAO;
import com.htp.repairService.dao.connectionPool.ConnectionPool;
import com.htp.repairService.dao.connectionPool.ConnectionPoolException;
import com.htp.repairService.domain.to.Faults;
import com.htp.repairService.exception.DaoException;
import javafx.application.Application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLFaultsDAO implements FaultsDAO {

    private static final String SELECT_ALL_FAULTS = "SELECT * FROM faults";
    private static final String FIND_BY_ID = "SELECT * FROM faults WHERE fault_id = ?";
    private static final String SELECT_FAULT = "SELECT * FROM faults WHERE fault_id = ? ";
    private static final String DELETE_FAULT = "DELETE FROM faults WHERE fault_id = ? ";
    private static final String ADD_FAULT = "INSERT INTO faults (fault_id, fault_sector, fault_type, date_in, date_done) VALUES(?, ?, ?, ?, ?) ";
    private static final String UPDATE_FAULT = "UPDATE faults SET fault_sector = ?, fault_type = ?, date_in = ?, date_done = ?";
    private static final String LAST_INSERT_ID = "SELECT last_insert_id() as lastId";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    private static final String FAULT_ID = "fault_id";
    private static final String SECTOR_FAULT_ID = "fault_sector";
    private static final String FAULT_TYPE = "fault_type";
    private static final String DATE_IN = "date_in";
    private static final String FINISH_DATE = "date_done";


    private static final String LAST_ID_ATTRIBUTE = "lastId";

    public SQLFaultsDAO() {
    }

    public static FaultsDAO getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final FaultsDAO instance = new SQLFaultsDAO();
    }

    /**
     * Method check fault in database by identification number
     *
     * @param faults object that will be checks for the presence of in database
     * @return true if fault with some unique number is in the database
     * @throws DaoException if there were errors while reading rooms from database.
     */

    @Override
    public boolean checkFaults(Faults faults) throws DaoException {
        try (Connection connect = pool.getConnection();
               PreparedStatement statement = connect.prepareStatement(SELECT_FAULT)) {

            statement.setInt(1, faults.getFault_id());
            ResultSet set = statement.executeQuery();
            return set.next();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    /**
     * Method find faults by information specified in the application: id, date, sector .
     *
     * @param app facility which searches
     * @return List rooms that can be find by information specified in the application
     * @throws DaoException if there were errors while reading rooms from database.
     */
    @Override
    public List<Faults> findByApplication(Application app) throws DaoException {
        return null;
    }

    @Override
    public List<Faults> findAll() throws DaoException {
        List<Faults> faults = new ArrayList<>();

        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_ALL_FAULTS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Faults fault = new Faults();

                fault.setFault_id(resultSet.getInt(FAULT_ID));
                fault.setSectorFault_id(resultSet.getInt(SECTOR_FAULT_ID));
                fault.setFault_type(resultSet.getString(FAULT_TYPE));
                fault.setDate_in(resultSet.getDate(DATE_IN));
                fault.setFinish_date(resultSet.getDate(FINISH_DATE));
                faults.add(fault);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return faults;
    }

    @Override
    public Faults findById(Integer fault_id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, fault_id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                Faults faults = new Faults();
                faults.setFault_id(set.getInt(FAULT_ID));
                faults.setSectorFault_id(set.getInt(SECTOR_FAULT_ID));
                faults.setFault_type(set.getString(FAULT_TYPE));
                faults.setDate_in(set.getDate(DATE_IN));
                faults.setFinish_date(set.getDate(FINISH_DATE));

                return faults;
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    /**
     * Method remove reservation node by id number from database
     *
     * @param id unique number of node in database
     * @return true if removing from database correctly
     * @throws DaoException if there were errors while removing reservations from database.
     */
    @Override
    public boolean delete(Integer id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(DELETE_FAULT)) {

            statement.setInt(1, id);
            statement.executeUpdate();
            return true;

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    /**
     * Method execute creating new fault node in database.
     *
     * @param newFault fault object that can be inserted in database.
     * @return unique number of new node.
     * @throws DaoException if there were errors while inserting data into database.
     */
    @Override
    public int create(Faults newFault) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(ADD_FAULT);
             PreparedStatement statementTwo = connect.prepareStatement(LAST_INSERT_ID)) {
            statement.setInt(1, newFault.getFault_id());
            statement.setInt(2, newFault.getSectorFault_id());
            statement.setString(3, newFault.getFault_type());
            statement.setDate(4, (Date) newFault.getDate_in());
            statement.setDate(5, (Date) newFault.getFinish_date());

            statement.executeUpdate();

            ResultSet set = statementTwo.executeQuery();
            set.next();
            return set.getInt(LAST_ID_ATTRIBUTE);
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }

    }

    @Override
    public Integer update(Faults updateFault) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(UPDATE_FAULT)) {
            statement.setString(1, updateFault.getFault_type());
            statement.setDate(2, (Date) updateFault.getFinish_date());

            statement.executeUpdate();
            return updateFault.getFault_id();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }
}