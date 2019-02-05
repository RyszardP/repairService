package com.htp.repairService.service.validator;


import com.htp.repairService.service.ServiceException;

/**
 * Created by user on 17.01.2019.
 */
public class ValidationException extends ServiceException {

    private static final long serialVersionUID = 1L;

    public ValidationException(String message){
        super(message);
    }

    public ValidationException(String message, Exception ex){
        super(message, ex);
    }
}