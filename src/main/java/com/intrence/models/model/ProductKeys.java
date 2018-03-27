/**
 * Created by wliu on 11/15/17.
 */
package com.intrence.models.model;

public enum ProductKeys {

    NAME_KEY("name"),
    DESCRIPTION_KEY("description"),
    DESIGNER_KEY("designer"),
    SEX_KEY("sex"),
    AVAILABLE_SIZES_KEY("available_sizes"),
    CLOTHING_CATEGORY_KEY("clothing_category"),
    ORIGINAL_PRICE_KEY("original_price"),
    CURRENT_PRICE_KEY("current_price"),
    IS_ON_SALE_KEY("is_on_sale"),
    SALE_DISCOUNT_KEY("sale_discount"),
    SOURCE_KEY("source"),
    EXTERNAL_LINK_KEY("external_link"),
    IMAGE_LINK_KEY("image_links");

    private final String productKey;

    ProductKeys(String productKey) {
        this.productKey = productKey;
    }

    public String toString() {
        return this.productKey;
    }


}
