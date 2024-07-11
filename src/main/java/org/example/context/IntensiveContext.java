package org.example.context;

import org.example.annotation.IntensiveComponent;
import org.example.factory.DependencyFactory;
import org.example.factory.DependencyFactoryImpl;
import org.example.service.injectionService.InjectionService;
import org.example.service.injectionService.injectionServiceImpl;
import org.example.service.searchService.SearchService;
import org.example.service.searchService.SearchServiceImpl;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anastasiya Vusik
 * This is class, wich manage with components. Components must be annotated with @IntensiveComponent
 */

public class IntensiveContext {

    private final DependencyFactory dependencyFactory = new DependencyFactoryImpl();
    private final SearchService searchService = new SearchServiceImpl();
    private final InjectionService injectionService = new injectionServiceImpl();
    private final String packageName;
    private final Map<Class<?>, Object> beans = new HashMap<>();


    /**
     * @param packageName is a package with classes have annotation @IntensiveComponent
     */

    public IntensiveContext(String packageName) {

        beans.put(SearchService.class, new SearchServiceImpl());        //???????????????????????

        this.packageName = packageName;
    }


    /**
     * Method gets instance of a component by its class
     *
     * @param type is a class of bean
     * @param <T>  is a bean type
     * @return is an instance of a bean
     */
    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> type) {

        if (beans.containsKey(type)) {
            return (T) beans.get(type);
        }

        Class<?> beanClass = searchService.searchClass(packageName, type);
        if (beanClass == null) {
            throw new RuntimeException("Component of class " + type.getName() + "is not found");
        }

        T instance = dependencyFactory.createInstance(beanClass);
        beans.put(type, instance);

        for (Field field : beanClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(IntensiveComponent.class)) {
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                Object fieldInstance = getObject(fieldType);
                injectionService.inject(instance, field, fieldInstance);

            }
        }

        return instance;
    }
}
