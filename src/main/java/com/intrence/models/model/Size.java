/**
 * Created by wliu on 11/26/17.
 */
package com.intrence.models.model;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum Size {

    XXX_SMALL("XXXS"),
    XX_SMALL("XXS"),
    X_SMALL("XS"),
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    X_LARGE("XL"),
    XX_LARGE("XXL"),
    XXX_LARGE("XXXL"),
    XXXX_LARGE("4XL");

    private static final Map<String, Size> standardToSizeMap = new HashMap<>();

    static {
        for (Size size : Size.values()) {
            standardToSizeMap.put(size.getStandard(), size);
        }
    }

    String standard;

    Size(String standard) {
        this.standard = standard;
    }

    public String getStandard() {
        return this.standard;
    }

    public static Size fromSizeStandard(String standard) {
        if (!StringUtils.isBlank(standard) && standardToSizeMap.containsKey(standard)) {
            return standardToSizeMap.get(standard);
        }
        throw new IllegalArgumentException("ClothingCategory DNE: " + standard);
    }

}
