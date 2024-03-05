package org.home.dev.config.service.initializer.client;

import org.home.dev.config.service.initializer.client.response.GetConfigResponse;
import org.home.dev.config.service.initializer.client.response.GetPropertyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "configService", url = "${config.service.url}")
public interface ConfigServiceClient {

    @GetMapping(value = "/configsByName")
    GetConfigResponse getConfigs(@RequestParam String propertyName);

    @GetMapping(value = "/properties")
    GetPropertyResponse getProperties();
}
