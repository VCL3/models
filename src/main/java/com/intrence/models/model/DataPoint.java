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

import java.io.IOException;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(builder = DataPoint.Builder.class)
public class DataPoint {

    private static final String METADATA_STRING = "metadata";
    private static final String PRODUCT_STRING = "product";

    private final MetaData metaData;
    private final Product product;

    public DataPoint(Builder builder) {
        this.metaData = builder.metaData;
        this.product = builder.product;
    }

    public static DataPoint fromJson(String jsonString) {
        try {
            return JsonHandler.getInstance().convertJsonStringToObject(jsonString, DataPoint.class);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String toJson() throws JsonProcessingException {
        return JsonHandler.getInstance().convertObjectToJsonString(this);
    }


    // Serialize getter methods
    @JsonProperty(METADATA_STRING)
    public MetaData getMetaData() {
        return this.metaData;
    }

    @JsonProperty(PRODUCT_STRING)
    public Product getProduct() {
        return this.product;
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
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

        DataPoint that = (DataPoint) o;

        if (this.product != null ? !this.product.equals(that.product) : that.product != null) {
            return false;
        }
        return true;
    }

    // Deserialize DataPoint class builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private MetaData metaData;
        private Product product;

        public Builder() {
        }

        public Builder(DataPoint dataPoint) {
            this.metaData = dataPoint.metaData;
            this.product = dataPoint.product;
        }

        @JsonSetter(METADATA_STRING)
        public Builder metaData(MetaData metaData) {
            this.metaData = metaData;
            return this;
        }

        @JsonSetter(PRODUCT_STRING)
        public Builder product(Product product) {
            this.product = product;
            return this;
        }

        public DataPoint build() {
            return new DataPoint(this);
        }
    }
}
