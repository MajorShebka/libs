package org.home.dev.config.service.initializer.annotations;

import org.home.dev.config.service.initializer.client.ConfigServiceClient;
import org.home.dev.config.service.initializer.entity.Properties;
import org.home.dev.config.service.initializer.postProcessor.PropertyAnnotationProcessor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@EnableFeignClients(clients = ConfigServiceClient.class)
@ComponentScan(basePackageClasses = {PropertyAnnotationProcessor.class, Properties.class})
public @interface EnableConfigService {
}
