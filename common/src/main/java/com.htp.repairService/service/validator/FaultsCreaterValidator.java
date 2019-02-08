package com.htp.repairService.service.validator;

import com.htp.repairService.domain.to.Faults;

import java.util.regex.Matcher;

public class FaultsCreaterValidator implements ValidatorInterface<Faults> {

    private static final ValidatorInterface<Faults> instance = new FaultsCreaterValidator();

    private FaultsCreaterValidator() {
    }

    public static ValidatorInterface<Faults> getInstance() {
        return instance;
    }

    @Override
    public boolean isValid(Faults faults) {
        System.out.println(faults);

        String fault_id = String.valueOf(faults.getFault_id());
        String fault_sector_id = String.valueOf(faults.getSectorFault_id());
        String fault_type = String.valueOf(faults.getFault_type());
        String date_in = String.valueOf(faults.getDate_in());
        String date_done = String.valueOf(faults.getFinish_date());

        return false;
    }
}
