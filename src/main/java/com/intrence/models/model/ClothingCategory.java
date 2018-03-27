/**
 * Created by wliu on 12/1/17.
 */
package com.intrence.models.model;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum ClothingCategory {

    COATS("coats"),
    DENIM("denim"),
    JACKETS("jackets"),
    PANTS("pants"),
    SHIRTS("shirts"),
    SHORTS("shorts"),
    SUITS("suits");

    private static final Map<String, ClothingCategory> nameToClothingCateogryMap = new HashMap<>();

    static {
        for (ClothingCategory clothingCategory : ClothingCategory.values()) {
            nameToClothingCateogryMap.put(clothingCategory.getName(), clothingCategory);
        }
    }

    private final String name;

    ClothingCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static ClothingCategory fromClothingCategoryName(String name) {
        if (!StringUtils.isBlank(name) && nameToClothingCateogryMap.containsKey(name)) {
            return nameToClothingCateogryMap.get(name);
        }
        throw new IllegalArgumentException("ClothingCategory DNE: " + name);
    }

}
