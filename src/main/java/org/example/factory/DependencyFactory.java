package org.example.factory;

public interface DependencyFactory {
    <T> T createInstance(Class<?> type);
}
