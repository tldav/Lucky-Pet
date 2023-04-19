package com.tekgs.nextgen.luckyPet.behavior;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ToStringBehavior {
    private final Object toStringObject;

    public ToStringBehavior(Object toStringObject) {
        this.toStringObject = toStringObject;
    }

    public static ToStringBehavior getInstance(Object toStringObject) {
        return new ToStringBehavior(toStringObject);
    }

    public String execute() {
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        return gson.toJson(this.toStringObject);
    }
}
