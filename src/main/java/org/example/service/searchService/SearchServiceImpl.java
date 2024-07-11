package org.example.service.searchService;

import org.example.annotation.IntensiveComponent;
import org.reflections.Reflections;

import java.util.Set;

/**
 * @author Anastasiya Vusik
 * Implementation of SearchService interface. This class look for beans (classes assigned with @IntensiveComponent)
 */

public class SearchServiceImpl implements SearchService {

    @Override
    public Class<?> searchClass(String packageName, Class<?> type) {

        Set<Class<?>> beansSet = findAllClasses(packageName);

        for(Class<?> bean : beansSet){
            if(type.isAssignableFrom(bean)){

                return bean;
            }
        }
            return null;
        }


    @Override
    public Set<Class<?>> findAllClasses(String packageName){

        Reflections reflections = new Reflections(packageName);

        return reflections.getTypesAnnotatedWith(IntensiveComponent.class);
    }
}
