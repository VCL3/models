/**
 * Created by wliu on 5/14/17.
 */
package com.intrence.models.model;

import com.intrence.models.util.JsonHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PriceTest {

    private static Integer amount = 1234;
    private static Integer currencyExponent = 2;
    private static String currencyCode = "USD";
    private static String basePriceJson = "{\"amount\":1234,\"currencyExponent\":2,\"currencyCode\":\"USD\",\"formattedAmount\":\"$12.34\"}";

    @Test
    public void testDeserializeFromJson() throws Exception {
        Price basePrice = JsonHandler.getInstance().convertJsonStringToObject(basePriceJson, Price.class);
        assertEquals(amount, basePrice.getAmount());
        assertEquals(currencyExponent, basePrice.getCurrencyExponent());
        assertEquals(currencyCode, basePrice.getCurrencyCode());
        assertEquals(Price.formattedAmountWithCurrency(amount, currencyCode), basePrice.getFormattedAmount());
    }

    @Test
    public void testSerializeToJson() throws Exception {
        assertEquals(basePriceJson, JsonHandler.getInstance().convertObjectToJsonString(getTestInstance()));
    }

    @Test
    public void testFormattedAmountWithCurrency() {
        assertEquals("$12.34", Price.formattedAmountWithCurrency(amount, currencyCode));
        assertEquals("$12.34", Price.formattedAmountWithCurrency(amount, "RMB"));
        assertEquals("$1,234.56", Price.formattedAmountWithCurrency(123456, currencyCode));
        assertEquals("$1,234,567.89", Price.formattedAmountWithCurrency(123456789, currencyCode));
        assertEquals("$1.23", Price.formattedAmountWithCurrency(123, currencyCode));
        assertEquals("$0.12", Price.formattedAmountWithCurrency(12, currencyCode));
    }

    @Test
    public void testBuildFromFormattedAmount() {

    }

    public static Price getTestInstance() {
        return new Price.Builder()
                .amount(amount)
                .currencyCode(currencyCode)
                .formattedAmount(Price.formattedAmountWithCurrency(amount, currencyCode))
                .build();
    }
}
