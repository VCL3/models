/**
 * Created by wliu on 11/27/17.
 */
package com.intrence.models.util;

import java.util.*;

public class CurrencyHandler {

    private static CurrencyHandler currencyHandler = null;
    private static Set<Locale> availableLocales = new HashSet<>(Arrays.asList(Locale.US));
    private final Map<String, Locale> currencySymbolToLocaleMap;
    private final Map<String, String> currencySymbolToCurrencyCodeMap;

    private CurrencyHandler() {
        currencySymbolToLocaleMap = new HashMap<>();
        currencySymbolToCurrencyCodeMap = new HashMap<>();
        for (Locale locale : availableLocales) {
            try {
                Currency currency = Currency.getInstance(locale);
                currencySymbolToLocaleMap.put(currency.getSymbol(locale), locale);
                currencySymbolToCurrencyCodeMap.put(currency.getSymbol(locale), currency.getCurrencyCode());
            } catch (Exception e) {
                // Not every locale has currency
            }
        }
    }

    public static CurrencyHandler getInstance() {
        if (currencyHandler == null) {
            synchronized (CurrencyHandler.class) {
                if (currencyHandler == null) {
                    currencyHandler = new CurrencyHandler();
                }
            }
        }
        return currencyHandler;
    }

    public Locale getLocaleFromCurrencySymbol(String currencySymbol) {
        if (currencySymbolToLocaleMap.containsKey(currencySymbol)) {
            return currencySymbolToLocaleMap.get(currencySymbol);
        }
        return null;
    }

    public String getCurrencyCodeFromCurrencySymbol(String currencySymbol) {
        if (currencySymbolToCurrencyCodeMap.containsKey(currencySymbol)) {
            return currencySymbolToCurrencyCodeMap.get(currencySymbol);
        }
        return null;
    }

}
