package com.htp.repairService.controller.command.impl.fault;

import com.htp.repairService.controller.command.CommandException;
import com.htp.repairService.controller.command.CommandInterface;
import com.htp.repairService.service.FaultService;
import com.htp.repairService.service.PagePath;
import com.htp.repairService.service.ServiceException;
import com.htp.repairService.service.impl.FaultsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFaultCommand implements CommandInterface {
    private static FaultService SERVICE = FaultsServiceImpl.getInstance();
    private static final String DELETE_FAULT_ID_ATTRIBUTE = "deleteId";
    private static final String ERROR_PAGE = "/error";

    private static final String ACTION = "action";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";

    private DeleteFaultCommand() {
    }

    public static class SingletonHolder {
        private static final CommandInterface INSTANCE = new DeleteFaultCommand();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        PagePath page = null;
        try {
            Long deleteFaultId = Long.valueOf(request.getParameter("fault_id"));
            boolean delete = SERVICE.delete(deleteFaultId);

        } catch (ServiceException e) {
            throw new CommandException("Command Exception", e);
        }
        return page.toString().toLowerCase();
    }
}




