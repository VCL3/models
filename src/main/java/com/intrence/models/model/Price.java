/**
 * Created by wliu on 5/5/17.
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
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(builder = Price.Builder.class)
public class Price {

    private Integer amount;
    private Integer currencyExponent;
    private String currencyCode;
    private String formattedAmount;

    private static final Integer DEFAULT_CURRENCY_EXPONENT = 2;

    private Price(Builder builder) {
        this.amount = builder.amount;
        // Default the currencyExponent to 2
        this.currencyExponent = builder.currencyExponent == null ? DEFAULT_CURRENCY_EXPONENT : builder.currencyExponent;
        this.currencyCode = builder.currencyCode;
        this.formattedAmount = builder.formattedAmount;
    }

    // Serialize getter methods
    @JsonProperty
    public Integer getAmount() {
        return this.amount;
    }

    @JsonProperty
    public Integer getCurrencyExponent() {
        return this.currencyExponent;
    }

    @JsonProperty
    public String getCurrencyCode() {
        return this.currencyCode;
    }

    @JsonProperty
    public String getFormattedAmount() {
        return this.formattedAmount;
    }

    /*
     * This method turns an integer amount into a formatted number with currency code
     * Right now only supports one currency, USD
     * The input amount will be in the unit of cents, for example, an item is $35 USD,
     * Then the amount will be 3500. After formatting, will output $35.00
     */
    public static String formattedAmountWithCurrency(Integer amount, String currencyCode) {

        String amountPattern = "([0-9]*)([0-9]{2})";
        Pattern pattern = Pattern.compile(amountPattern);
        Matcher matcher = pattern.matcher(amount.toString());

        if (matcher.find()) {
            String amountWhole = matcher.group(1);
            if (amountWhole.isEmpty()) {
                amountWhole = "0";
            }
            String amountDecimal = matcher.group(2);
            switch (currencyCode) {
                case "USD":
                    // Formats the integer part of a number to follow the US standard E.g, 1234567 -> 1,234,567
                    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
                    String formattedAmountWhole = numberFormat.format(Integer.parseInt(amountWhole));
                    return String.format("$%s.%s", formattedAmountWhole, amountDecimal);
                default:
                    return String.format("$%s.%s", amountWhole, amountDecimal);
            }
        }
        throw new IllegalArgumentException("Cannot match the pattern of given integer");
    }

    public static Price fromJson(String jsonString) {
        try {
            return JsonHandler.getInstance().convertJsonStringToObject(jsonString, Price.class);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String toJson() throws JsonProcessingException {
        return JsonHandler.getInstance().convertObjectToJsonString(this);
    }

    @Override
    public String toString() {
        return String.format("amount: %s, currencyExponent: %s, currencyCode: %s, formattedAmount: %s",
                amount, currencyExponent, currencyCode, formattedAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (amount != null ? !amount.equals(price.amount) : price.amount != null) return false;
        if (currencyExponent != null ? !currencyExponent.equals(price.currencyExponent) : price.currencyExponent != null) return false;
        if (currencyCode != null ? !currencyCode.equals(price.currencyCode) : price.currencyCode != null) return false;
        if (formattedAmount != null ? !formattedAmount.equals(price.formattedAmount) : price.formattedAmount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (currencyExponent != null ? currencyExponent.hashCode() : 0);
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + (formattedAmount != null ? formattedAmount.hashCode() : 0);
        return result;
    }

    // Deserialization
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {

        private Integer amount;
        private Integer currencyExponent;
        private String currencyCode;
        private String formattedAmount;

        public Builder(Price price) {
            this.amount = price.amount;
            this.currencyExponent = price.currencyExponent;
            this.currencyCode = price.currencyCode;
            this.formattedAmount = price.formattedAmount;
        }

        public Builder() {
        }

        @JsonSetter
        public Builder amount(Integer amount) {
            this.amount = amount;
            return this;
        }

        @JsonSetter
        public Builder currencyExponent(Integer currencyExponent) {
            this.currencyExponent = currencyExponent;
            return this;
        }

        @JsonSetter
        public Builder formattedAmount(String formattedAmount) {
            this.formattedAmount = formattedAmount;
            return this;
        }

        @JsonSetter
        public Builder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public Price build() {
            return new Price(this);
        }
    }

}
