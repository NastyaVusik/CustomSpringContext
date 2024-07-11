package org.example.service.injectionService;

import org.example.context.IntensiveContext;

import java.lang.reflect.Field;

/**
 * @author Anastasiya Vusik
 * Interface for injection something
 */

public interface InjectionService {
    void inject(Object bean, Object value);
}
