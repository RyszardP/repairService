package dao.factory;

import dao.*;
import dao.impls.*;
import domain.to.Employee;
import domain.to.Sector;
import domain.to.Workshop;

public class SQLDaoFactory extends DaoFactory {

        private static final SQLDaoFactory instance = new SQLDaoFactory();

        private SQLDaoFactory(){}

        public static SQLDaoFactory getInstance(){
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
    public SectorDAO getSectorDao() { return SQLSectorDAO.getInstance();}

    @Override
    public WorkshopDAO getWorkshopDao() { return SQLWorkshopDAO.getInstance();}

    @Override
    public FaultsDAO getFaultsDao() { return SQLFaultsDAO.getInstance();}

    @Override
    public BrigadeDAO getBrigadeDao (){return SQLBrigadeDAO.getInstance();}


       
    }


