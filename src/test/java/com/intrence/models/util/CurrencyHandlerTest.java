/**
 * Created by wliu on 11/27/17.
 */
package com.intrence.models.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CurrencyHandlerTest {

    @Test
    public void testTranslateUSD() {
        Locale locale = CurrencyHandler.getInstance().getLocaleFromCurrencySymbol("$");

        Assert.assertTrue(locale.equals(Locale.US));
    }

    @Test
    public void testGetCurrencyCode() {
        String currencyCode = CurrencyHandler.getInstance().getCurrencyCodeFromCurrencySymbol("$");
        Assert.assertEquals("USD", currencyCode);
    }

}
