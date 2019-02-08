package com.htp.repairService.controller.command.impl.fault;

import com.htp.repairService.controller.command.CommandException;
import com.htp.repairService.controller.command.CommandInterface;
import com.htp.repairService.domain.to.Faults;
import com.htp.repairService.service.FaultService;
import com.htp.repairService.service.PagePath;
import com.htp.repairService.service.impl.FaultsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

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

    public static class  SingletonHolder {
        private static final CommandInterface INSTANCE = new UpdateFaultCommand();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = null;

        try {
            String fault_sector = request.getParameter(FAULT_SECTOR);
            String fault_type = request.getParameter(FAULT_TYPE);
            String date_in = request.getParameter(FAULT_DATE_IN);
            String data_done = request.getParameter(FAULT_DATE_DONE);

            Faults faults = new Faults();
            faults.setSectorFault_id(Integer.valueOf(fault_sector));
            faults.setFault_type(String.valueOf(fault_type));
            faults.setDate_in(Date.valueOf(date_in));
            faults.setFinish_date(Date.valueOf(data_done));

            boolean check = SERVICE.fixedRoom(faults);
            if (check){
                page = PagePath.UPDATE_FAULT.toString();
            } else {
                page = PagePath.ERROR.toString();
            }
            HttpSession session = request.getSession();
            session.setAttribute(SESSION_GOOD_MESSAGE, SESSION_GOOD_MESSAGE_VALUE);
            request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);
        } catch (Exception e) {
            throw new CommandException("Command Exception", e);
        }
        return page.toString().toLowerCase();
    }
}
