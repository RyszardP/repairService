package com.htp.repairService.service;


import com.htp.repairService.domain.to.WorkerBrigade;
import com.htp.repairService.service.ServiceException;

public interface WorkerService  {

    /**
     * Method provides operation for login user
     *
     * @param worker object, that provides authorization operation
     * @return {@link WorkerBrigade} - login record
     * @throws ServiceException
     */

    WorkerBrigade authorization(WorkerBrigade worker) throws ServiceException;

    Long create(WorkerBrigade worker) throws ServiceException;
}
