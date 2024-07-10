package org.example.postprocessor;

import org.example.annotation.IntensiveComponent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anastasiya Vusik
 */

public class IntensiveBeanPostprocessor implements BeanPostProcessor {

    private final Map<String, Class> beanMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Class<?> beanClass = bean.getClass();
        if(beanClass.isAnnotationPresent(IntensiveComponent.class)){
            beanMap.put(beanName, beanClass);
        }

//        Field[] declaredFields = bean.getClass().getDeclaredFields();
//
//        for (Field field: declaredFields) {
//            IntensiveComponent annotation = field.getAnnotation(IntensiveComponent.class);
//
//            if(annotation!= null){
//                String str =  annotation.message();
//                field.setAccessible(true);
//                ReflectionUtils.setField(field, bean, str);
//            }
//
//        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class beanClass = beanMap.get(beanName);

        if(beanClass != null){
            return bean;
        }
else {
    return new BeanCreationException("Class" + beanName + " isn't bean");
        }
    }
}