package com.calebogb.ehr.exception;

public class EHRServiceException extends Exception {

    public EHRServiceException(String message){
        super(message);
    }

    public EHRServiceException(Throwable cause){
        super(cause);
    }

}
