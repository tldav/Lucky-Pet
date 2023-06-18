package com.tekgs.nextgen.luckyPet.view.error.copy;

import com.tekgs.nextgen.luckyPet.view.copy.LuckyPetCopy;

public class ErrorViewCopy {
    private LuckyPetCopy copy;
    
    private ErrorViewCopy() {
    }
    
    public static ErrorViewCopy getInstance() {
        return new ErrorViewCopy();
    }
    
    public String getError404() {
        return this.getCopy().getError404();
    }
    
    public String getGenericError() {
        return this.getCopy().getGenericError();
    }
    
    private LuckyPetCopy getCopy() {
        if (this.copy == null) {
            this.copy = LuckyPetCopy.getInstance();
        }
        return this.copy;
    }
}
