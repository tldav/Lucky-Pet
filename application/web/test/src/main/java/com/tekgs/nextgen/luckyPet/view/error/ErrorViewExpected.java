package com.tekgs.nextgen.luckyPet.view.error;

import com.tekgs.nextgen.luckyPet.view.error.copy.ErrorViewCopy;

public class ErrorViewExpected implements ErrorViewCalibratable {
    private ErrorViewCopy copy;
    private final String message;

    public ErrorViewExpected(String errorCode) {
        String errorMessage = "404".equals(errorCode) ? getCopy().getError404() : getCopy().getGenericError();
        this.message = String.format("%s! \uD83D\uDC15", errorMessage);
    }

    public static ErrorViewExpected getNotFoundInstance() {
        return new ErrorViewExpected("404");
    }

    public static ErrorViewExpected getGenericInstance() {
        return new ErrorViewExpected(null);
    }

    @Override
    public String getMessage() {
        return message;
        }

    private ErrorViewCopy getCopy() {
        if (copy == null) {
            copy = ErrorViewCopy.getInstance();
        }
        return copy;
    }
}
