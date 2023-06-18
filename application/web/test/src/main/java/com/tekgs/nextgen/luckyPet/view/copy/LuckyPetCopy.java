package com.tekgs.nextgen.luckyPet.view.copy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LuckyPetCopy {
    private final Properties properties = new Properties();
    
    private LuckyPetCopy() {
        String locale = System.getProperty("locale");
        locale = locale == null || locale.equals("") ? "en-us" : locale;
        String filename = String.format("../source/src/copy/%s.properties", locale);
        try (FileInputStream inStream = new FileInputStream(filename)) {
            this.properties.load(inStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static LuckyPetCopy getInstance() {
        return new LuckyPetCopy();
    }
    
    public String getPurchaseConfirmationMessage() {
        return this.properties.getProperty("purchase-confirmation-message");
    }
    
    public String getError404() {
        return this.properties.getProperty("error-404");
    }
    
    public String getGenericError() {
        return this.properties.getProperty("generic-error");
    }
}
