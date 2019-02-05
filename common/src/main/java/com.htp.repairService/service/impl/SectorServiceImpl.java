package com.htp.repairService.service.impl;

import com.htp.repairService.dao.factory.DaoFactory;

import com.htp.repairService.domain.to.Faults;
import com.htp.repairService.domain.to.Sector;
import com.htp.repairService.service.SectorService;
import com.htp.repairService.service.ServiceException;


import java.util.List;

public class SectorServiceImpl implements SectorService {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();


    @Override
    public boolean deleteSector(int id) throws ServiceException {
        return false;
    }

    @Override
    public Sector findById(int id) throws ServiceException {
        return null;
    }


    @Override
    public Faults create(Object entity) throws ServiceException {
        return null;
    }

    @Override
    public List loadAll() throws ServiceException {
        return null;
    }
}
