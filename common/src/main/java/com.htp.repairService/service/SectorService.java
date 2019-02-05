package com.htp.repairService.service;


import com.htp.repairService.domain.to.Sector;



public interface SectorService extends GenericServiceInterface {

    boolean deleteSector(int id) throws ServiceException;

    Sector findById(int id) throws ServiceException;


}
