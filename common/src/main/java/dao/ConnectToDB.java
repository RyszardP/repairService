package dao;


import dao.connectionPool.ConnectionPool;
import dao.connectionPool.ConnectionPoolException;
import dao.factory.DaoFactory;

import exception.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
    public static void main(String[] args) throws ConnectionPoolException {
        ConnectionPool.getInstance().init();
        DaoFactory factory = DaoFactory.getDaoFactory();
        EmployeeDAO employeeDao = factory.getEmployeeDao();

        try {

            Object empl1 = employeeDao.checkEmployee("Ivanov","12345");
            Object empl2 = employeeDao.checkEmployee("Matvey","12345");

            System.out.println(empl1);
            System.out.println(empl2);



        } catch (DaoException e) {
            e.printStackTrace();
        }


    /*private static String URL = "jdbc:mysql://localhost:3306/workshopdata?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";


        Connection connect = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Соединение установлено");


        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        } finally {
            try {
                if (connect.isClosed()) {

                    connect.close();
                    System.out.println("Disconnect");
                }
            } catch (SQLException e) {
                System.out.println("Disconnect");
            }
        }
    }*/




    }
}

