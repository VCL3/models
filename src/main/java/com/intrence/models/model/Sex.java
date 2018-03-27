/**
 * Created by wliu on 1/19/18.
 */
package com.intrence.models.model;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum Sex {
    MEN("MEN"),
    WOMEN("WOMEN"),
    UNISEX("UNISEX"),
    NOSEX("NOSEX");

    private static final Map<String, Sex> stringToSexMap = new HashMap<>();

    static {
        for (Sex sex : Sex.values()) {
            stringToSexMap.put(sex.getSexString(), sex);
        }
    }

    String sexString;

    Sex(String sexString) {
        this.sexString = sexString;
    }

    public String getSexString() {
        return this.sexString;
    }

    public static Sex fromSexString(String sexString) {
        if (!StringUtils.isBlank(sexString) && stringToSexMap.containsKey(sexString)) {
            return stringToSexMap.get(sexString);
        }
        throw new IllegalArgumentException("Sex DNE: " + sexString);
    }
}
