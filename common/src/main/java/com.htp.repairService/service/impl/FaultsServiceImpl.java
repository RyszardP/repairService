package com.htp.repairService.service.impl;

import com.htp.repairService.dao.FaultsDAO;
import com.htp.repairService.dao.factory.DaoFactory;
import com.htp.repairService.domain.to.Faults;
import com.htp.repairService.exception.DaoException;
import com.htp.repairService.service.FaultService;
import com.htp.repairService.service.ServiceException;

import java.util.List;

public class FaultsServiceImpl implements FaultService {
    private static final DaoFactory factory = DaoFactory.getDaoFactory();

    private FaultsServiceImpl() {
    }

    public static FaultService getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final FaultService instance = new FaultsServiceImpl();
    }

    @Override
    public Long create(Faults faults) throws ServiceException {
        FaultsDAO faultsDAO = factory.getFaultsDao();
        try {
            faultsDAO.create(faults);

        } catch (DaoException e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    public Faults create(Object entity) throws ServiceException {
        return null;
    }

    @Override
    public List<Faults> loadAll() throws ServiceException {
        List<Faults> faultsList;
        try {
            FaultsDAO faultsDAO =factory.getFaultsDao();
            faultsList = faultsDAO.findAll();
            return faultsList;
        } catch (DaoException e){
            throw new ServiceException("Service Exception", e);
        }
    }

    @Override
    public Faults loadById(int reservationId) throws ServiceException {
        return null;
    }

    @Override
    public Faults findById(int id) throws ServiceException {
        return null;
    }


}
