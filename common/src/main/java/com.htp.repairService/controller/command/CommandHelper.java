package com.htp.repairService.controller.command;

import com.htp.repairService.controller.command.impl.LoginCommand;
import com.htp.repairService.controller.command.impl.RegistrationCommand;
import com.htp.repairService.controller.command.impl.TestCommand;
import com.htp.repairService.controller.command.impl.employee.CreateEmployeeCommand;
import com.htp.repairService.controller.command.impl.fault.CreateFaultCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandHelper {
    private static final String ATTRIBUTE_COMMAND = "command";
    private static final String DASH = "-";
    private static final String UNDERSCORE = "_";

    private final Map<CommandName, CommandInterface> commands = new HashMap<>();

    public CommandHelper() {
        commands.put(CommandName.AUTORIZATION, LoginCommand.getInstance());
        // commands.put(CommandName.VIEW_ALL_EMPLOYEES, ViewEmployeesCommand.getInstance());
        commands.put(CommandName.REGISTRATION, RegistrationCommand.getInstance());
        commands.put(CommandName.CREATE_EMPLOYEE, CreateEmployeeCommand.getInstance());
        commands.put(CommandName.TEST_COMMAND, TestCommand.getInstance());
        commands.put(CommandName.CREATE_FAULT_COMMAND, CreateFaultCommand.getInstance());

    }

    /**
     * Method determines by request of which command is needed and returns the command object
     *
     * @param request HttpServletRequest
     * @return command object if command exists in map, else return null
     */
    public CommandInterface getCommand(HttpServletRequest request) {
        String commandName = request.getParameter(ATTRIBUTE_COMMAND);
        if (commandName != null) {
            CommandName name = CommandName.valueOf(commandName.toUpperCase().replace(DASH, UNDERSCORE));
            return commands.get(name);
        } else {
            return null;
        }
    }

    private enum CommandName {
        AUTORIZATION, CREATE_EMPLOYEE, VIEW_ALL_EMPLOYEES, TEST_COMMAND, REGISTRATION, CREATE_FAULT_COMMAND
    }
}