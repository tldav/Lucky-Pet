package com.tekgs.nextgen.luckyPet.behavior;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ToStringBehavior {
    private static ToStringBehavior toStringBehavior;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().disableHtmlEscaping().create();

    public static ToStringBehavior getInstance() {
        if (toStringBehavior == null) {
            return new ToStringBehavior();
        }
        return toStringBehavior;
    }

    public String execute(Object objectToJsonify) {
        return this.gson.toJson(objectToJsonify);
    }

    public void print(Object objectToPrint) {
        System.out.printf(objectToPrint.getClass().getSimpleName() + ": ");
        System.out.println(this.gson.toJson(objectToPrint));
    }
}
