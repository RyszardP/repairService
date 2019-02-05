package com.htp.repairService.dao.factory;


import com.htp.repairService.dao.BrigadeDAO;
import com.htp.repairService.dao.EmployeeDAO;
import com.htp.repairService.dao.FaultsDAO;
import com.htp.repairService.dao.SectorDAO;
import com.htp.repairService.dao.WorkerDAO;
import com.htp.repairService.dao.WorkshopDAO;

public abstract class DaoFactory {
    public static DaoFactory getDaoFactory() {
        return SQLDaoFactory.getInstance();
    }

    public abstract EmployeeDAO getEmployeeDao();
    public abstract WorkerDAO getWorkerDao();
    public abstract SectorDAO getSectorDao();
    public abstract WorkshopDAO getWorkshopDao();
    public abstract FaultsDAO getFaultsDao();
    public abstract BrigadeDAO getBrigadeDao();



}
