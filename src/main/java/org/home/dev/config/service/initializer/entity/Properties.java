package org.home.dev.config.service.initializer.entity;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.home.dev.config.service.initializer.client.ConfigServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class Properties {

    private ConfigServiceClient configService;

    @Autowired
    public void setConfigService(@Lazy ConfigServiceClient configService){
        this.configService = configService;
    }
    @Getter
    private Map<String, Config> configs = new HashMap<>();

    public void init(String propertyName) {
        List<Config> configsList = configService.getConfigs(propertyName).getConfigs();
        configs = new HashMap<>();
        configsList.forEach(config -> configs.put(config.getName(), config));
    }
}
