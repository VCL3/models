package com.intrence.models.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.io.IOException;

public class JsonHandler {

    private static JsonHandler jsonHandler;
    private final ObjectMapper OBJECT_MAPPER;

    private JsonHandler() {
        OBJECT_MAPPER = (new ObjectMapper())
                .registerModule(new JodaModule())
                .registerModule(new GuavaModule())
                .setDateFormat(new ISO8601DateFormat())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public String convertObjectToJsonString(Object object) throws JsonProcessingException {

        return OBJECT_MAPPER.writeValueAsString(object);
    }

    public <T> T convertJsonStringToObject(String jsonString, Class<T> classType) throws IOException {

        return OBJECT_MAPPER.readValue(jsonString, classType);
    }

    public static JsonHandler getInstance() {

        if (jsonHandler == null) {

            synchronized (JsonHandler.class) {

                if (jsonHandler == null) {

                    jsonHandler = new JsonHandler();
                }
            }
        }

        return jsonHandler;
    }

}
