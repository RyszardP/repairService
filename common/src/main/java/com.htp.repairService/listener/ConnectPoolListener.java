package com.htp.repairService.listener;

import com.htp.repairService.dao.connectionPool.ConnectionPool;
import com.htp.repairService.dao.connectionPool.ConnectionPoolException;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/* The class that initialize connection pool with parameters described in property file.
 */
public class ConnectPoolListener implements ServletContextListener {
    private static final Logger LOGGER_ROOT = Logger.getRootLogger();

    private ConnectionPool pool;

    /**
     * Call method dispose() on connection pool object, that remove all connections in pool
     *
     * @param arg0
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        try {
            pool.dispose();
        } catch (ConnectionPoolException e) {
            LOGGER_ROOT.error("ConnectionPoolException", e);
            throw new RuntimeException("ConnectionPoolException! Application is not available!", e);
        }
    }

    /**
     * Call method init()  on connection pool object
     *
     * @param arg0
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        pool = ConnectionPool.getInstance();
        try {
            pool.init();
        } catch (ConnectionPoolException e) {
            LOGGER_ROOT.error("ConnectionPoolException", e);
            throw new RuntimeException("ConnectionPoolException! Application is not available!", e);
        }
    }
}