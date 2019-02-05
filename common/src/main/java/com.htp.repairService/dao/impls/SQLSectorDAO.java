package com.htp.repairService.dao.impls;

import com.htp.repairService.dao.SectorDAO;
import com.htp.repairService.dao.connectionPool.ConnectionPool;
import com.htp.repairService.dao.connectionPool.ConnectionPoolException;
import com.htp.repairService.domain.to.Sector;
import com.htp.repairService.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLSectorDAO implements SectorDAO {

    public static SectorDAO getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final SectorDAO instance = new SQLSectorDAO();
    }


    private static final String SELECT_ALL_SECTORS = "SELECT * FROM sector";
    private static final String FIND_BY_ID = "SELECT * FROM sector WHERE sector_id = ?";
    private static final String SELECT_SECTOR = "SELECT * FROM sector WHERE sector_id = ?";
    private static final String DELETE_SECTOR = "DELETE FROM sector WHERE sector_id = ?";
    private static final String ADD_SECTOR = "INSERT INTO sector (sector_id, master_id, sectorTitle , sector_owner) VALUES (?, ?, ?, ?) ";
    private static final String UPDATE_SECTOR = "UPDATE sector SET master_id = ?, sector_title = ?, sector_owner = ? WHERE sector_id = ?";
    private static final String LAST_INSERT_ID = "SELECT last_insert_id() as lastId ";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    private static final String SECTOR_ID = "sector_id";
    private static final String MASTER_ID = "master_id";
    private static final String SECTOR_TITLE = "sector_title";
    private static final String SECTOR_OWNER = "sector_owner";
    private static final String LAST_ID_ATTRIBUTE = "lastId";


    private SQLSectorDAO() {
    }

    /**
     * Method check sector in database by identification number
     *
     * @param sector object that will be checks for the presence of in database
     * @return true if room with some unique number is in the database
     * @throws DaoException if there were errors while reading sectors from database.
     */

    @Override
    public boolean checkSector(Sector sector) throws DaoException {

        try (Connection connection = pool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SECTOR)) {

            statement.setInt(1, sector.getSector_id());
            statement.setString(2, sector.getSectorTitle());
            ResultSet set = statement.executeQuery();
            return set.next();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    /**
     * Reading from database all sectors
     *
     * @return List of all rooms storing in database or empty list, if no nodes in database
     * @throws DaoException if there were errors while reading rooms from database.
     */
    @Override
    public List<Sector> findAll() throws DaoException {
        List<Sector> sectorList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_ALL_SECTORS)) {
            ResultSet resultSets = statement.executeQuery();
            while (resultSets.next()) {
                Sector sector = new Sector();

                sector.setSector_id(resultSets.getInt(SECTOR_ID));
                sector.setMaster_id(resultSets.getInt(MASTER_ID));
                sector.setSectorTitle(resultSets.getString(SECTOR_TITLE));
                sector.setSector_owner(resultSets.getInt(SECTOR_OWNER));
            }
            return sectorList;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    /**
     * Method find in database some sector by unique number.
     *
     * @param id unique number of node in database
     * @return sector object if node can be found in database, else return null.
     * @throws DaoException if there were errors while reading sectors from database.
     */
    @Override
    public Sector findById(Integer id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                Sector sector = new Sector();
                sector.setSector_id(set.getInt(SECTOR_ID));
                sector.setMaster_id(set.getInt(MASTER_ID));
                sector.setSectorTitle(set.getString(SECTOR_TITLE));
                sector.setSector_owner(set.getInt(SECTOR_OWNER));
                return sector;
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    /**
     * Method remove node by id number from database
     *
     * @param id unique number of node in database
     * @return true if removing from database correctly
     * @throws DaoException if there were errors while removing sector from database.
     */
    @Override
    public boolean delete(Integer id) throws DaoException {

        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(DELETE_SECTOR)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    /**
     * Method execute creating new workshop sector node in database.
     *
     * @param newSector workshop sector object that can be inserted in database.
     * @return unique number of new node.
     * @throws DaoException if there were errors while inserting data into database.
     */
    @Override
    public int create(Sector newSector) throws DaoException {

        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(ADD_SECTOR);
             PreparedStatement statementSecond = connect.prepareStatement(LAST_INSERT_ID)) {

            statement.executeUpdate();
            ResultSet set = statementSecond.executeQuery();
            set.next();
            return set.getInt(LAST_ID_ATTRIBUTE);
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    /**
     * Method change fields of object sector and return unique number of updated node
     *
     * @param updateSector object with new actually information
     * @return unique number of updated node
     * @throws DaoException if there were errors while updating data into database.
     */
    @Override
    public Integer update(Sector updateSector) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(UPDATE_SECTOR)) {
            statement.setInt(1, updateSector.getMaster_id());
            statement.setString(2, updateSector.getSectorTitle());
            statement.setInt(3, updateSector.getSector_owner());

            statement.executeUpdate();
            return updateSector.getSector_id();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

}
