package org.home.dev.config.service.initializer.config;

import org.home.dev.config.service.initializer.client.ConfigServiceClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = ConfigServiceClient.class)
public class Configs {
}
