package org.example.service.injectionService;

import java.lang.reflect.Field;

/**
 * @author Anastasiya Vusik
 * Interface for injection components to IntensiveContext
 */

public interface InjectionService {
    void inject(Object bean, Field field, Object value);
}
