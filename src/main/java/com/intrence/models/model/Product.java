/**
 * Created by wliu on 11/8/17.
 */
package com.intrence.models.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.intrence.models.util.JsonHandler;
import org.joda.time.DateTime;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(builder = Product.Builder.class)
public class Product {

    private UUID uuid;
    private String name;
    private String description;
    private String designer;
    private Sex sex;
    private Set<Size> availableSizes;
    private ClothingCategory clothingCategory;

    private Price originalPrice;
    private Price currentPrice;
    private Boolean isOnSale;
    private Integer saleDiscount;

    private String source;
    private String externalLink;
    private List<String> imageLinks;

    private DateTime createdAt;
    private DateTime updatedAt;

    public Product(Builder builder) {
        // Check for product minimal requirements
        if (builder.name == null || builder.currentPrice == null || builder.externalLink == null) {
            throw new IllegalArgumentException("Product doesn't have enough information");
        }

        this.uuid = builder.uuid;
        this.name = builder.name;
        this.description = builder.description;
        this.designer = builder.designer;
        this.sex = builder.sex;
        this.availableSizes = builder.availableSizes;
        this.clothingCategory = builder.clothingCategory;
        this.originalPrice = builder.originalPrice;
        this.currentPrice = builder.currentPrice;
        this.isOnSale = builder.isOnSale;
        this.saleDiscount = builder.saleDiscount;
        this.source = builder.source;
        this.externalLink = builder.externalLink;
        this.imageLinks = builder.imageLinks;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public static Product fromJson(String jsonString) {
        try {
            return JsonHandler.getInstance().convertJsonStringToObject(jsonString, Product.class);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String toJson() throws JsonProcessingException {
        return JsonHandler.getInstance().convertObjectToJsonString(this);
    }


    // Serialize getter methods
    @JsonProperty
    public UUID getUuid() {
        return this.uuid;
    }

    @JsonProperty
    public String getName() {
        return this.name;
    }

    @JsonProperty
    public String getDescription() {
        return this.description;
    }

    @JsonProperty
    public String getDesigner() {
        return this.designer;
    }

    @JsonProperty
    public Sex getSex() {
        return this.sex;
    }

    @JsonProperty
    public Set<Size> getAvailableSizes() {
        return this.availableSizes;
    }

    @JsonProperty
    public ClothingCategory getClothingCategory() {
        return this.clothingCategory;
    }

    @JsonProperty
    public Price getOriginalPrice() {
        return this.originalPrice;
    }

    @JsonProperty
    public Price getCurrentPrice() {
        return this.currentPrice;
    }

    @JsonProperty
    public Boolean getIsOnSale() {
        return this.isOnSale;
    }

    @JsonProperty
    public Integer getSaleDiscount() {
        return this.saleDiscount;
    }

    @JsonProperty
    public String getSource() {
        return this.source;
    }

    @JsonProperty
    public String getExternalLink() {
        return this.externalLink;
    }

    @JsonProperty
    public List<String> getImageLinks() {
        return this.imageLinks;
    }

    @JsonProperty
    public DateTime getCreatedAt() {
        return this.createdAt;
    }

    @JsonProperty
    public DateTime getUpdatedAt() {
        return this.updatedAt;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Product that = (Product) o;

        if (this.name != null ? !this.name.equals(that.name) : that.name != null) {
            return false;
        }
        return true;
    }

    // Deserialize Product class builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private UUID uuid;
        private String name;
        private String description;
        private String designer;
        private Sex sex;
        private Set<Size> availableSizes;
        private ClothingCategory clothingCategory;

        private Price originalPrice;
        private Price currentPrice;
        private Boolean isOnSale;
        private Integer saleDiscount;

        private String source;
        private String externalLink;
        private List<String> imageLinks;

        private DateTime createdAt;
        private DateTime updatedAt;

        public Builder() {
        }

        public Builder(Product product) {
            this.uuid = product.uuid;
            this.name = product.name;
            this.description = product.description;
            this.designer = product.designer;
            this.sex = product.sex;
            this.availableSizes = product.availableSizes;
            this.clothingCategory = product.clothingCategory;
            this.originalPrice = product.originalPrice;
            this.currentPrice = product.currentPrice;
            this.isOnSale = product.isOnSale;
            this.saleDiscount = product.saleDiscount;
            this.source = product.source;
            this.externalLink = product.externalLink;
            this.imageLinks = product.imageLinks;
        }

        @JsonSetter
        public Builder uuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        @JsonSetter
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        @JsonSetter
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        @JsonSetter
        public Builder designer(String designer) {
            this.designer = designer;
            return this;
        }

        @JsonSetter
        public Builder sex(Sex sex) {
            this.sex = sex;
            return this;
        }

        @JsonSetter
        public Builder availableSizes(Set<Size> availableSizes) {
            this.availableSizes = availableSizes;
            return this;
        }

        @JsonSetter
        public Builder clothingCategory(ClothingCategory clothingCategory) {
            this.clothingCategory = clothingCategory;
            return this;
        }

        @JsonSetter
        public Builder originalPrice(Price originalPrice) {
            this.originalPrice = originalPrice;
            return this;
        }

        @JsonSetter
        public Builder currentPrice(Price currentPrice) {
            this.currentPrice = currentPrice;
            return this;
        }

        @JsonSetter
        public Builder isOnSale(Boolean isOnSale) {
            this.isOnSale = isOnSale;
            return this;
        }

        @JsonSetter
        public Builder saleDiscount(Integer saleDiscount) {
            this.saleDiscount = saleDiscount;
            return this;
        }

        @JsonSetter
        public Builder source(String source) {
            this.source = source;
            return this;
        }

        @JsonSetter
        public Builder externalLink(String externalLink) {
            this.externalLink = externalLink;
            return this;
        }

        @JsonSetter
        public Builder imageLinks(List<String> imageLinks) {
            this.imageLinks = imageLinks;
            return this;
        }

        @JsonSetter
        public Builder createdAt(DateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @JsonSetter
        public Builder updatedAt(DateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}