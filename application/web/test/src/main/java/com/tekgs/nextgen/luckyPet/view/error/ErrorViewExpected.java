package com.tekgs.nextgen.luckyPet.view.error;

import com.tekgs.nextgen.luckyPet.view.error.copy.ErrorViewCopy;

public class ErrorViewExpected implements ErrorViewCalibratable {
    private final String message;
    private ErrorViewCopy copy;
    
    private ErrorViewExpected(String errorCode) {
        String errorMessage = "404".equals(errorCode) ? this.getCopy().getError404() : this.getCopy().getGenericError();
        this.message = String.format("%s! \uD83D\uDC15", errorMessage);
    }
    
    public static ErrorViewExpected getNotFoundInstance() {
        return new ErrorViewExpected("404");
    }
    
    public static ErrorViewExpected getGenericInstance() {
        return new ErrorViewExpected(null);
    }
    
    private ErrorViewCopy getCopy() {
        if (this.copy == null) {
            this.copy = ErrorViewCopy.getInstance();
        }
        return this.copy;
    }
    
    @Override
    public String getMessage() {
        return this.message;
    }
}
