package org.example.factory;

/**
 * @author Anastasiya Vusik
 * Interface for design pattern component, which used in the implementation of a custom dependency injection framework
 */

public interface DependencyFactory {
    <T> T createInstance(Class<T> type);
}
