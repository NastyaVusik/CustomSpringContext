package org.example.factory;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Anastasiya Vusik
 * Implementation of DependencyFactory interface. This class contains method, which create instances of classes, handling
 * the instantiation logic
 */

public class DependencyFactoryImpl implements DependencyFactory {

    /**
     * Method to create instance from required class. Method use reflection to call the default constructor of the class.
     *
     * @param type - represent class.
     * @param <T>  - say, that this method use generic
     * @return - return new instance of the class type by invoking its default constructor
     */
    @Override
    public <T> T createInstance(Class<T> type) {

        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance " + type.getName(), e);
        }
    }

}
