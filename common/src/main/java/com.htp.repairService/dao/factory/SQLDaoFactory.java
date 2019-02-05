package com.htp.repairService.dao.factory;

import com.htp.repairService.dao.BrigadeDAO;

import com.htp.repairService.dao.EmployeeDAO;
import com.htp.repairService.dao.FaultsDAO;
import com.htp.repairService.dao.SectorDAO;
import com.htp.repairService.dao.WorkerDAO;
import com.htp.repairService.dao.WorkshopDAO;
import com.htp.repairService.dao.impls.SQLBrigadeDAO;
import com.htp.repairService.dao.impls.SQLEmployeeDao;
import com.htp.repairService.dao.impls.SQLFaultsDAO;
import com.htp.repairService.dao.impls.SQLSectorDAO;
import com.htp.repairService.dao.impls.SQLWorkerDAO;
import com.htp.repairService.dao.impls.SQLWorkshopDAO;

public class SQLDaoFactory extends DaoFactory {

    private static final SQLDaoFactory instance = new SQLDaoFactory();

    private SQLDaoFactory() {
    }

    public static SQLDaoFactory getInstance() {
        return instance;
    }


    @Override
    public EmployeeDAO getEmployeeDao() {
        return SQLEmployeeDao.getInstance();
    }

    @Override
    public WorkerDAO getWorkerDao() {
        return SQLWorkerDAO.getInstance();
    }

    @Override
    public SectorDAO getSectorDao() {
        return SQLSectorDAO.getInstance();
    }

    @Override
    public WorkshopDAO getWorkshopDao() {
        return SQLWorkshopDAO.getInstance();
    }

    @Override
    public FaultsDAO getFaultsDao() {
        return SQLFaultsDAO.getInstance();
    }

    @Override
    public BrigadeDAO getBrigadeDao() {
        return SQLBrigadeDAO.getInstance();
    }


}


