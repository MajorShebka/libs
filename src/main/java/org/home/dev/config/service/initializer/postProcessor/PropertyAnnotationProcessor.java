package org.home.dev.config.service.initializer.postProcessor;

import jakarta.annotation.Nullable;
import org.home.dev.config.service.initializer.annotations.Property;
import org.home.dev.config.service.initializer.client.ConfigServiceClient;
import org.home.dev.config.service.initializer.entity.AbstractProperty;
import org.home.dev.config.service.initializer.entity.Properties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;

@Component
public class PropertyAnnotationProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(@Nullable Object bean, String beanName) {
        return bean;
    }

    private Object init(Object bean) {
        Class<?> managedBeanClass = bean.getClass();
        Property property = managedBeanClass.getAnnotation(Property.class);
        if (Objects.nonNull(property)) {
            Class<?> c = AbstractProperty.class;
            try {
                Field f = c.getDeclaredField("properties");
                f.setAccessible(true);
                Properties p = (Properties) f.get(bean);
                p.init(property.name());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return init(bean);
    }
}
