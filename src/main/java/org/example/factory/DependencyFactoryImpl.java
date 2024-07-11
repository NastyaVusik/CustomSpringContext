package org.example.factory;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Anastasiya Vusik
 * Implementation of DependencyFactory interface. This class create instances of classes, handling the instantiation logic
 */

public class DependencyFactoryImpl implements DependencyFactory{

    @Override
    public <T> T createInstance(Class<T> type){

        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance " + type.getName(), e);
        }
    }

}
