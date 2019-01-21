package dao.factory;


import dao.*;
import domain.to.Employee;

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
