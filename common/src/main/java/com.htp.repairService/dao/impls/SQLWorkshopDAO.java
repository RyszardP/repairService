package com.htp.repairService.dao.impls;


import com.htp.repairService.dao.WorkshopDAO;
import com.htp.repairService.dao.connectionPool.ConnectionPool;
import com.htp.repairService.dao.connectionPool.ConnectionPoolException;
import com.htp.repairService.domain.to.Workshop;
import com.htp.repairService.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLWorkshopDAO implements WorkshopDAO {

    public static WorkshopDAO getInstance() {
        return SQLWorkshopDAO.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final WorkshopDAO instance = new SQLWorkshopDAO();
    }

    public SQLWorkshopDAO() {
    }

    private static final String SELECT_ALL_WORKSHOP = "SELECT * FROM workshop";
    private static final String FIND_BY_ID = "SELECT * FROM workshop WHERE workshop_id = ?";
    private static final String SELECT_WORKSHOP = "SELECT * FROM workshop WHERE workshop_id = ?";
    private static final String DELETE_WORKSHOP = "DELETE FROM workshop WHERE workshop_id = ?";
    private static final String ADD_WORKSHOP = "INSERT INTO workshop (workshop_id, workshop_master_id, workshop_title) VALUES (?, ?, ?) ";
    private static final String UPDATE_WORKSHOP = "UPDATE workshop SET workshop_master_id = ?, workshop_title = ? WHERE workshop_id = ?";
    private static final String LAST_INSERT_ID = "SELECT last_insert_id() as lastId ";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    private static final String WORKSHOP_ID = "workshop_id";
    private static final String MASTER_ID = "master_id";
    private static final String WORKSHOP_TITLE = "workshop_title";
    private static final String LAST_ID_ATTRIBUTE = "lastId";

    @Override
    public boolean checkWorkshop(Workshop workshop) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_WORKSHOP)) {

            statement.setInt(1, workshop.getWorkshop_id());
            statement.setString(2, workshop.getWorkshop_title());
            ResultSet set = statement.executeQuery();
            return set.next();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public List<Workshop> findAll() throws DaoException {
        List<Workshop> workshopList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_ALL_WORKSHOP)) {
            ResultSet resultSets = statement.executeQuery();
            while (resultSets.next()) {
                Workshop workshop = new Workshop();

                workshop.setWorkshop_id(resultSets.getInt(WORKSHOP_ID));
                workshop.setWorkshop_master_id(resultSets.getInt(MASTER_ID));
                workshop.setWorkshop_title(resultSets.getString(WORKSHOP_TITLE));

            }
            return workshopList;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }

    }

    @Override
    public Workshop findById(Integer id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                Workshop workshop = new Workshop();
                workshop.setSector_id(set.getInt(WORKSHOP_ID));
                workshop.setMaster_id(set.getInt(MASTER_ID));
                workshop.setSectorTitle(set.getString(WORKSHOP_TITLE));

                return workshop;
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(DELETE_WORKSHOP)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public int create(Workshop newWorkshop) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(ADD_WORKSHOP);
             PreparedStatement statementSecond = connect.prepareStatement(LAST_INSERT_ID)) {

            statement.executeUpdate();
            ResultSet set = statementSecond.executeQuery();
            set.next();
            return set.getInt(LAST_ID_ATTRIBUTE);
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public Integer update(Workshop updateWorkshop) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(UPDATE_WORKSHOP)) {
            statement.setInt(1, updateWorkshop.getWorkshop_master_id());
            statement.setString(2, updateWorkshop.getWorkshop_title());

            statement.executeUpdate();
            return updateWorkshop.getWorkshop_id();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }
}
