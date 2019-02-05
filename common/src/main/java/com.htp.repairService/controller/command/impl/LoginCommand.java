package com.htp.repairService.controller.command.impl;

import com.htp.repairService.controller.command.CommandException;
import com.htp.repairService.controller.command.CommandInterface;
import com.htp.repairService.controller.command.util.PagesConfigManager;
import com.htp.repairService.domain.to.Administrator;
import com.htp.repairService.domain.to.Employee;
import com.htp.repairService.service.EmployeeService;
import com.htp.repairService.service.PagePath;
import com.htp.repairService.service.ServiceException;
import com.htp.repairService.service.impl.EmployeeServiceImpl;
import com.htp.repairService.service.validator.ValidationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements CommandInterface {

    private static final EmployeeService SERVICE = EmployeeServiceImpl.getInstance();
    // private static final PagesConfigManager MANAGER = PagesConfigManager.getInstance();
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ADMIN_ROLE = "admin";
    private static final String EMPLOYEE_ROLE = "employee";
    private static final String ERROR_FLAG = "errorFlag";
    private static final int ERROR_FLAG_VALUE = 1;
    private static final String ACTION = "action";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    private LoginCommand() {
    }

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new LoginCommand();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        return null;
    }

    /**
     * Method performs the procedure for authorization in system
     * In first, getting login and password parameters from request
     * Then finding node with equals parameters. If procedure return not null, then necessary define client or admin
     * log in. According to role of user creating admin or client object and put into session.
     * <p>
     * Also determines what action must be made for transition(forward or sendRedirect)
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return the path to go to a specific page
     * @throws CommandException if authorization method process fail
     */


      /*  PagePath page;
        try {
            Employee tempEmployee = new Employee();
            tempEmployee.setLogin(request.getParameter(LOGIN));
            String password = request.getParameter(PASSWORD);
            tempEmployee.setPassword(password);

            HttpSession session = request.getSession(true);
            Employee employee = SERVICE.authorization(tempEmployee);

            if (employee == null) {
                request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE);
                request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
                page = PagePath.INDEX;
            } else {
                if (employee.getRole().equals(ADMIN_ROLE)) {
                    Administrator admin = new Administrator();
                    admin.setPassword(employee.getPassword());
                    admin.setLogin(employee.getLogin());
                    admin.setRole(employee.getRole());

                    session.setAttribute(ADMIN_ROLE, admin);
                    page = PagePath.ADMIN;
                }
                request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);
            }
        } catch (ValidationException e) {
            request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE);
            request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
            page = PagePath.INDEX;
        } catch (ServiceException e) {
            throw new CommandException("Command Exception", e);
        }
return null;
     // return MANAGER.getProperty(page.toString());
    }*/
}
