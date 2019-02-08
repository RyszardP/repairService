package com.htp.repairService.controller.command.impl.fault;

import com.htp.repairService.controller.command.CommandException;
import com.htp.repairService.controller.command.CommandInterface;
import com.htp.repairService.dao.FaultsDAO;
import com.htp.repairService.dao.factory.DaoFactory;
import com.htp.repairService.exception.DaoException;
import com.htp.repairService.service.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class TestCommand implements CommandInterface {
    private static final String ACTION = "action";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    private TestCommand() {
    }

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Method performs the procedure for adding hotel room information on page and further viewing and updating
     * Also determines what action must be made for transition(forward or sendRedirect)
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return the path to go to a specific page
     * @throws CommandException when getting all nodes fail
     */


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        PagePath page = null;
        DaoFactory factory1 = DaoFactory.getDaoFactory();
        FaultsDAO faultsDAO = factory1.getFaultsDao();
        try {
            page = PagePath.FAULTSLIST;
            request.setAttribute("testList", Arrays.asList(faultsDAO.findAll()));
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
        return "/" + page.toString().toLowerCase();
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new TestCommand();
    }
}