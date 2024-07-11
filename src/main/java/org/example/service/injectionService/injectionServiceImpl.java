package org.example.service.injectionService;

import org.example.annotation.IntensiveComponent;

import java.lang.reflect.Field;

/**
 * @author Anastasiya Vusik
 * Implementation of InjectionService interface. This class inject dependencies for beans (classes assigned with @IntensiveComponent)
 */

public class injectionServiceImpl implements InjectionService{

    @Override
    public void inject(Object targetObject, Field field, Object value) {
        Field[] declaredFields = targetObject.getClass().getDeclaredFields();

        for (Field field1: declaredFields) {
            IntensiveComponent annotation = field1.getAnnotation(IntensiveComponent.class);

            if(annotation!= null){
                field.setAccessible(true);
                try {
                    field.set(targetObject, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed while injection value in a field " + field.getName());
                }
            }
        }
    }
}
