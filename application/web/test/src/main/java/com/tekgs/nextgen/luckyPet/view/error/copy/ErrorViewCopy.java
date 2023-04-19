package com.tekgs.nextgen.luckyPet.view.error.copy;

import com.tekgs.nextgen.luckyPet.view.copy.LuckyPetCopy;

public class ErrorViewCopy {
    private LuckyPetCopy copy;

    public static ErrorViewCopy getInstance() {
        return new ErrorViewCopy();
    }

    public String getError404() {
        return getCopy().getError404();
    }

    private LuckyPetCopy getCopy() {
        if (copy == null) {
            copy = LuckyPetCopy.getInstance();
        }
        return copy;
    }

    public String getGenericError() {
        return getCopy().getGenericError();
    }
}
