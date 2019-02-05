package com.htp.repairService.service.validator;

import com.htp.repairService.domain.to.Sector;

import java.util.regex.Pattern;

public class SectorCreaterValidator implements ValidatorInterface {

   private static final ValidatorInterface<Sector>instance = new SectorCreaterValidator();

    public boolean isValid(Object entity) {
        return false;
    }

    public SectorCreaterValidator() {    }

    public static ValidatorInterface<Sector>getInstance(){return instance; }


}
