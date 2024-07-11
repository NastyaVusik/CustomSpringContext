package org.example.factory;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Anastasiya Vusik
 * Implementation of DependencyFactory interface. This class inject dependencies for beans (classes assigned with @IntensiveComponent)
 */

public class DependencyFactoryImpl implements DependencyFactory{

    @Override
    public <T> T createInstance(Class<?> type){

        try {
            return (T) type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance " + type.getName(), e);
        }
    }

}
