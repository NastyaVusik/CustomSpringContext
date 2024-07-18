package org.example.service.searchService;

import org.example.annotation.IntensiveComponent;
import org.reflections.Reflections;

import java.util.Set;

/**
 * @author Anastasiya Vusik
 * Implementation of SearchService interface. This class contains method to look for beans
 * (classes assigned with @IntensiveComponent)
 */

public class SearchServiceImpl implements SearchService {

    /**
     * Method search for  classes annotated with a specific annotation
     * (in this case, @IntensiveComponent) within a given package.
     *
     * @param packageName - target package with classes for injection in custom context
     * @param type        - class from Set beanSet, which contains only classes with annotation @IntensiveComponent
     * @return - if required class contains in beanSet, return this class, else return null
     */
    @Override
    public Class<?> searchClass(String packageName, Class<?> type) {

        Set<Class<?>> beansSet = findAllClasses(packageName);

        for (Class<?> bean : beansSet) {
            if (type.equals(bean)) {          //(type.isAssignableFrom(bean))??????????????????????????????????????????

                return bean;
            }
        }
        return null;
    }


    @Override
    public Set<Class<?>> findAllClasses(String packageName) {

        Reflections reflections = new Reflections(packageName);

        return reflections.getTypesAnnotatedWith(IntensiveComponent.class);
    }
}
