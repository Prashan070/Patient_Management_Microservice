package com.pm.patientservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT)
public class PatentAlreadyExistException extends RuntimeException {

    public PatentAlreadyExistException(String message) {
        super(message);
    }


}
