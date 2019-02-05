package com.htp.repairService.controller.command.impl.employee;

import com.htp.repairService.controller.command.CommandException;
import com.htp.repairService.controller.command.CommandInterface;
import com.htp.repairService.controller.command.util.PagesConfigManager;
import com.htp.repairService.controller.command.util.Pagination;
import com.htp.repairService.domain.to.Employee;
import com.htp.repairService.service.EmployeeService;
import com.htp.repairService.service.PagePath;
import com.htp.repairService.service.ServiceException;
import com.htp.repairService.service.impl.EmployeeServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ViewEmployeesCommand implements CommandInterface {

    private static final EmployeeService SERVICE = EmployeeServiceImpl.getInstance();
    private static final PagesConfigManager MANAGER = PagesConfigManager.getInstance();
    private static final Pagination<Employee> pagination = Pagination.getInstance();

    private static final String ACTION = "action";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    private ViewEmployeesCommand (){}

    public static CommandInterface getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new ViewEmployeesCommand ();
    }

    /**
     * Method performs the procedure for viewing all login clients
     * Also determines what action must be made for transition(forward or sendRedirect)
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return the path to go to a specific page
     * @throws CommandException when getting all client nodes fail
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        String page;
        List<Employee> listEmployees;
        try {
            listEmployees= SERVICE.viewAll();
            pagination.paging(request, listEmployees);
            page = PagePath.EMPLOYEE_MANAGE.toString();

        } catch (ServiceException e) {
            throw new CommandException("Command Exception", e);
        }
        request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
        return MANAGER.getProperty(page);
    }
}
