package dao;

import domain.to.Sector;
import exception.DaoException;

public interface SectorDAO extends GenericDAO<Sector, Integer> {
/**
 * Method checks workshops sectors to be present in the database
 *
 * @param sector object that will be checks for the presence of in database
 * @return boolean result of operation
 * @throws DaoException
 */

boolean checkSector(Sector sector) throws DaoException;
}
