package com.htp.repairService.service;

import com.htp.repairService.domain.to.Faults;

import java.util.List;


public interface FaultService extends GenericServiceInterface<Faults, List<Faults>>  {




    Faults findById(int id) throws ServiceException;

    boolean delete(int deleteFaultId) throws ServiceException;

    boolean fixedRoom(Faults faults) throws ServiceException;

}
