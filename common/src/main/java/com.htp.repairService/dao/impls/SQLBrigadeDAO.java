package com.htp.repairService.dao.impls;

import com.htp.repairService.dao.BrigadeDAO;
import com.htp.repairService.dao.connectionPool.ConnectionPool;
import com.htp.repairService.dao.connectionPool.ConnectionPoolException;
import com.htp.repairService.domain.to.Brigade;
import com.htp.repairService.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SQLBrigadeDAO implements BrigadeDAO {
    private static final String SELECT_BY_ID = "SELECT * FROM brigade WHERE brigade_id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM brigade WHERE brigade_id = ?";
    private static final String SELECT_ALL_BRIGADES = "SELECT * FROM brigade";
    private static final String SELECT_BRIGADE = "SELECT * FROM brigade WHERE  specialty = ?";
    private static final String UPDATE_BRIGADE = "UPDATE brigade\n" +
            " SET brigade_id = ?\n" +
            " WHERE brigade_id = ?";

    private static final String BRIGADE_ID = "brigade_id";
    private static final String BRIGADE_SPECIALITY = "specialty";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    public SQLBrigadeDAO() {
    }

    private static class SingletonHolder {
        private static final BrigadeDAO instance = new SQLBrigadeDAO();
    }

    public static BrigadeDAO getInstance() {
        return SingletonHolder.instance;
    }


    @Override
    public boolean checkBrigade(Brigade brigade) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BRIGADE)) {

            statement.setInt(1, brigade.getBrigadeId());
            ResultSet set = statement.executeQuery();
            return set.next();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public List<Brigade> findAll() throws DaoException {
        List<Brigade> brigadeList = new ArrayList<>();

        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_ALL_BRIGADES)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Brigade brigade = new Brigade();

                brigade.setBrigadeId(resultSet.getInt(BRIGADE_ID));
                brigade.setBrigadeSpeciality(resultSet.getString(BRIGADE_SPECIALITY));

            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return brigadeList;
    }

    @Override
    public Brigade findById(Integer id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                Brigade brigade = new Brigade();
                brigade.setBrigadeId(set.getInt(BRIGADE_ID));
                brigade.setBrigadeSpeciality(set.getString(BRIGADE_SPECIALITY));

                return brigade;
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
    public int create(Brigade entity) throws DaoException {
        return 0;
    }

    @Override
    public Integer update(Brigade entity) throws DaoException {
        return null;
    }
}
