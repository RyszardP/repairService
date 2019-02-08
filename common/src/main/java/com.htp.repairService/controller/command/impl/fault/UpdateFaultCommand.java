package com.htp.repairService.controller.command.impl.fault;

import com.htp.repairService.controller.command.CommandException;
import com.htp.repairService.controller.command.CommandInterface;
import com.htp.repairService.service.FaultService;
import com.htp.repairService.service.impl.FaultsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFaultCommand implements CommandInterface {

    private static final FaultService SERVICE = FaultsServiceImpl.getInstance();

    private static final String FAULT_SECTOR = "fault_sector";
    private static final String FAULT_TYPE = "fault_type";
    private static final String FAULT_DATE_IN = "date_in";
    private static final String FAULT_DATE_DONE = "date_done";
    private static final String ACTION = "action";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";

    private static final String SESSION_GOOD_MESSAGE = "message";
    private static final String SESSION_GOOD_MESSAGE_VALUE = "faultUpdate";

    private  UpdateFaultCommand(){}

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        return null;
    }
}
