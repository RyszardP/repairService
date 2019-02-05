package com.htp.repairService.controller.command.impl.employee;

import com.htp.repairService.controller.command.CommandException;
import com.htp.repairService.controller.command.CommandInterface;
import com.htp.repairService.controller.command.util.PagesConfigManager;
import com.htp.repairService.domain.to.Employee;
import com.htp.repairService.service.EmployeeService;
import com.htp.repairService.service.PagePath;
import com.htp.repairService.service.impl.EmployeeServiceImpl;
import com.htp.repairService.service.validator.ValidationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateEmployeeCommand implements CommandInterface {
    private static final EmployeeService SERVICE = EmployeeServiceImpl.getInstance();
    private static final PagesConfigManager MANAGER = PagesConfigManager.getInstance();
    private static final String LOGIN_ATTRIBUTE = "login";
    private static final String PASSWORD_ATTRIBUTE = "password";

    private static final String ACTION = "action";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    private static final String SESSION_GOOD_MESSAGE = "message";
    private static final String SESSION_GOOD_MESSAGE_VALUE = "employeeCreate";

    private static final String SUCCESS_CREATE_PAGE_REDIRECT = "/FrontController?command=create_employee";
    private static final String ERROR_FLAG = "errorFlag";
    private static final int ERROR_FLAG_VALUE = 1;

    private CreateEmployeeCommand(){}

    public static CommandInterface getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new CreateEmployeeCommand();
    }

    /**
     * Method performs the procedure for adding employee information in system
     * Getting parameter's from form with information about employee
     * Then creating a employee object and adding in system by executing service method
     * Also determines what action must be made for transition(forward or sendRedirect)
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return the path to go to a specific page
     * @throws CommandException where executing method fail
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page;
        try {
            String login = request.getParameter(LOGIN_ATTRIBUTE);
            String password = request.getParameter(PASSWORD_ATTRIBUTE);


            Employee employee = new Employee();

            employee.setLogin(String.valueOf(login));
            employee.setPassword(String.valueOf(password));


            SERVICE.create(employee);
            page = SUCCESS_CREATE_PAGE_REDIRECT;
            HttpSession session = request.getSession();
            session.setAttribute(SESSION_GOOD_MESSAGE, SESSION_GOOD_MESSAGE_VALUE);
            request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);

        } catch (ValidationException e) {
            request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE);
            request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
            page = MANAGER.getProperty(PagePath.CREATE_EMPLOYEE.toString());
        } catch (Exception e) {
            throw new CommandException("Command Exception", e);
        }
        return page;
    }
}

