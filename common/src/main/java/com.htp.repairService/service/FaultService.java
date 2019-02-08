package com.htp.repairService.service;

import com.htp.repairService.domain.to.Faults;


public interface FaultService extends GenericServiceInterface  {
    Faults create(Faults faults) throws ServiceException;



    Faults findById(int id) throws ServiceException;

    boolean delete(Long deleteFaultId) throws ServiceException;
}
