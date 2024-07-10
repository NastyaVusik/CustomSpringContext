package org.example.service.injectionService;

import java.lang.reflect.Field;

public interface InjectionService {
    void inject(Object target, Field field, Object value);
}
