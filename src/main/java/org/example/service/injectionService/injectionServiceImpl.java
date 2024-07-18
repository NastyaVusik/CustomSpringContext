package org.example.service.injectionService;

import org.example.annotation.IntensiveComponent;

import java.lang.reflect.Field;

/**
 * @author Anastasiya Vusik
 * Implementation of InjectionService interface. This class contains method, which inject dependencies for beans
 * (classes assigned with @IntensiveComponent)
 */

public class injectionServiceImpl implements InjectionService {

    /**
     * Method to inject dependencies in fields of Class<?> type with annotation @IntensiveComponent
     *
     * @param targetObject - This parameter represents the instance of the class into which the dependency is to be
     *                     injected. It is the object that contains the field that needs to be set.
     * @param field        - fields with annotation @IntensiveComponent
     * @param value        - This parameter represents the dependency that is to be injected into the field. It is the
     *                     actual value that you want to set on the specified field of the target object
     * @param type         - represent class, whose fields we want to check
     */
    @Override
    public void inject(Object targetObject, Field field, Object value, Class<?> type) {
//        Field[] declaredFields = targetObject.getClass().getDeclaredFields();
        Field[] declaredFields = type.getDeclaredFields();

        for (Field field1 : declaredFields) {
            IntensiveComponent annotation = field1.getAnnotation(IntensiveComponent.class);

            if (annotation != null) {
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
