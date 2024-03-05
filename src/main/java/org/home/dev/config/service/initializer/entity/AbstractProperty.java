package org.home.dev.config.service.initializer.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public abstract class AbstractProperty {

    @Autowired
    private Properties properties;

    public String getString(String configName) {
        return properties.getConfigs().get(configName).getValue();
    }

    public Long getLong(String configName) {
        return parseNumericValue(properties.getConfigs().get(configName).getValue(), Long::parseLong);
    }

    public Integer getInteger(String configName) {
        return parseNumericValue(properties.getConfigs().get(configName).getValue(), Integer::parseInt);
    }

    public Double getDouble(String configName) {
        return parseNumericValue(properties.getConfigs().get(configName).getValue(), Double::parseDouble);
    }

    private <T> T parseNumericValue(String value, Function<String, T> function) {
        try {
            return isNumericValueEmpty(value) ? null : function.apply(value);
        } catch (Exception e) {
            throw e;
        }
    }

    private boolean isNumericValueEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
