package com.htp.repairService.service.impl;

import com.htp.repairService.dao.FaultsDAO;
import com.htp.repairService.dao.factory.DaoFactory;
import com.htp.repairService.domain.to.Faults;
import com.htp.repairService.exception.DaoException;

import com.htp.repairService.service.FaultService;
import com.htp.repairService.service.ServiceException;
import com.htp.repairService.service.validator.FaultsCreaterValidator;
import com.htp.repairService.service.validator.ValidationException;
import com.htp.repairService.service.validator.ValidatorInterface;
import com.htp.repairService.service.GenericServiceInterface;

import java.util.List;

public class FaultsServiceImpl implements FaultService {
    private static final DaoFactory factory = DaoFactory.getDaoFactory();
    private static final ValidatorInterface<Faults> VALIDATOR = FaultsCreaterValidator.getInstance();

    private FaultsServiceImpl() {
    }

    public static FaultService getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final FaultService instance = new FaultsServiceImpl();
    }



    @Override
    public Faults create(Faults faults) throws ServiceException {
        try {
            if (VALIDATOR.isValid(faults)) {
                FaultsDAO faultsDAO = factory.getFaultsDao();
                faultsDAO.create(faults);
                return faults;
            } else {
                throw new ValidationException("Validation Exception");
            }
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }



    @Override
    public List<Faults> loadAll() throws ServiceException {
        List<Faults> faultsList;
        try {
            FaultsDAO faultsDAO = factory.getFaultsDao();
            faultsList = faultsDAO.findAll();
            return faultsList;
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }


    @Override
    public Faults findById(int id) throws ServiceException {
        Faults result;
        try {
            FaultsDAO faults = factory.getFaultsDao();
            result = faults.findById(id);
            if(result != null) {
                return result;
            } else {
                return null;
            }
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }

    @Override
    public boolean delete(int deleteFaultId) throws ServiceException {
        try {
            FaultsDAO faultDao = factory.getFaultsDao();
            return faultDao.delete(deleteFaultId);
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }

    @Override
    public boolean fixedRoom(Faults faults) throws ServiceException {
        return false;
    }


}
