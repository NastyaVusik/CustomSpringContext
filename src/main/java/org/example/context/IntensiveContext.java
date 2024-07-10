package org.example.context;

import org.example.service.searchService.Search;
import org.example.service.searchService.SearchImpl;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anastasiya Vusik
 */

public class IntensiveContext extends GenericApplicationContext {

    private final Map<Class<?>, Object> beans = new HashMap<>();


    public IntensiveContext(String packageName){

        beans.put(Search.class, new SearchImpl());

        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(this);
        int i = propertiesBeanDefinitionReader.loadBeanDefinitions(packageName);
        System.out.println("found " + i + " beans");
//        refresh();            //????????????????????????????
    }


    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> type){

        return (T) beans.get(type);
    }
}
